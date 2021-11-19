package br.com.spring.cache.demo.controller;


import br.com.spring.cache.demo.exception.BillingNotFoundException;
import br.com.spring.cache.demo.model.Billing;
import br.com.spring.cache.demo.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/billing")
@EnableCaching
public class BillingController {

    private static final Logger log = LoggerFactory.getLogger(BillingController.class);

    @Autowired
    BillingService billingService;

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public CustomResponseEntity<List<Billing>> findBillingAll() throws BillingNotFoundException {
        List<Billing> getRequest = billingService.findBillingAll();

        if(getRequest.size() > 0)
            return new CustomResponseEntity<>(getRequest, HttpStatus.OK );
        else
            throw new BillingNotFoundException("Billings not Found in database");
    }


    @GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public CustomResponseEntity<Billing> getPostById(@PathVariable String id) throws BillingNotFoundException {
        Billing getRequest = billingService.findBillingById(id);

        if(getRequest != null)
            return new CustomResponseEntity<>(getRequest, HttpStatus.OK );

        else
            throw new BillingNotFoundException("Billings with id "+id+" not found in database ");

    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "body", key = "#id")
    public CustomResponseEntity deleteById(@PathVariable String id) throws BillingNotFoundException{
        Billing find = billingService.findBillingById(id);

        if(find != null) {
            billingService.deleteBillingById(id);
            return new CustomResponseEntity<>(find, HttpStatus.OK );
        }else
            throw new  BillingNotFoundException("Billings with id "+id+" not found in database for delete");
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE )
    public CustomResponseEntity insertBilling(@RequestBody Billing billing) throws BillingNotFoundException {
        if(billing != null) {
            billingService.insertBilling(billing);
            return new CustomResponseEntity<>(billing, HttpStatus.OK );
        }else
            throw new  BillingNotFoundException("Billings could't insert on databse");
    }
}
