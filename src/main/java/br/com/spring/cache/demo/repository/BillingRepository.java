package br.com.spring.cache.demo.repository;

import br.com.spring.cache.demo.model.Billing;
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

    @Query("{id:'?0'}")
    Billing update(String id);

    @Query("{id:'?0'}")
    Billing insert(Billing doc);

}
