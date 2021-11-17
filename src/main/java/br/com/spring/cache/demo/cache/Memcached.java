package br.com.spring.cache.demo.cache;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.transcoders.SerializingTranscoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.io.IOException;
import java.util.concurrent.Callable;

public class Memcached implements Cache {

    private static final Logger LOGGER = LoggerFactory.getLogger(Memcached.class);

    private String name;

    private MemcachedClient cache;

    private int expiration;

    public Memcached(String name, String memcachedAddress, int expiration) throws IOException {
        this.name = name;
        this.expiration = expiration;

        this.cache = new MemcachedClient(
                new ConnectionFactoryBuilder()
                        .setTranscoder(new SerializingTranscoder())
                        .setProtocol(ConnectionFactoryBuilder.Protocol.BINARY)
                        .build(),
                AddrUtil.getAddresses(memcachedAddress)
        );
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return cache;
    }

    @Override
    public ValueWrapper get(Object key) {
        Object value = null;

        try {
            value = cache.get(key.toString());
        }catch (final Exception e){
            LOGGER.warn(e.getMessage());
        }

        if (value == null){
            LOGGER.debug("cache miss for key: "+key);
            return null;
        }

        LOGGER.debug("cache hit for key: "+key);
        return new SimpleValueWrapper(value);
    }

    @Override
    public void put(Object key, Object value) {
            if(value != null){
                cache.set(key.toString(), expiration, value);
                LOGGER.debug("cache put for key: "+key);
            }
    }

    @Override
    public void evict(Object key) {
        this.cache.delete(key.toString());
        LOGGER.debug("cache delete for key: "+ key);
    }

    @Override
    public void clear() {
        cache.flush();
        LOGGER.debug("cache clear completed");
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

}
