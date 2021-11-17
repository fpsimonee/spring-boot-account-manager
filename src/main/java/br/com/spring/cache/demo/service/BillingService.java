package br.com.spring.cache.demo.service;

import br.com.spring.cache.demo.exception.PostNotFoundException;
import br.com.spring.cache.demo.model.Billing;
import br.com.spring.cache.demo.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BillingService {

    @Autowired
    BillingRepository billigRepo;


    public Billing findBillingById(String id) throws PostNotFoundException, IOException {
        return billigRepo.findBillingById(id);
    }

    public List<Billing> findBillingAll() throws PostNotFoundException, IOException {
        return billigRepo.findAll();
    }

    public void deleteBillingById(String id) throws PostNotFoundException, IOException {
       billigRepo.deleteById(id);
    }

    public Billing insertBilling(Billing billing) throws PostNotFoundException, IOException {
        return billigRepo.save(billing);
     }
}
