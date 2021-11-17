package br.com.spring.cache.demo.repository;

import br.com.spring.cache.demo.model.Billing;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BillingRepository extends MongoRepository<Billing, String> {

    @Query("{id:'?0'}")
    Billing findBillingById(String id);

    @DeleteQuery("{id:'?0'}")
    void deleteById(String id);

}
