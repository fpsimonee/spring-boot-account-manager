package br.com.spring.cache.demo.controller;


import br.com.spring.cache.demo.exception.PostNotFoundException;
import br.com.spring.cache.demo.model.Billing;
import br.com.spring.cache.demo.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/billing")
public class BillingController {

    private static final Logger log = LoggerFactory.getLogger(BillingController.class);

    @Autowired
    BillingService billingService;

    @GetMapping()
    public List<Billing> findBillingAll() throws PostNotFoundException, IOException {
        return billingService.findBillingAll();
    }

    @Cacheable(value = "billing-single", key = "#id")
    @GetMapping("/{id}")
    public Billing getPostById(@PathVariable String id) throws PostNotFoundException, IOException {
        log.info("search for post id: "+id);
//        log.info(billingService.findBillingById(id));

        return billingService.findBillingById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id) throws PostNotFoundException, IOException{
        billingService.deleteBillingById(id);
        return "ok";
    }
    
    @PostMapping("/insert")
    public Billing insertBilling(@RequestBody Billing billing) throws PostNotFoundException, IOException {
        return billingService.insertBilling(billing);
    }
    
}
