package br.com.spring.cache.demo.service;

import br.com.spring.cache.demo.exception.BillingNotFoundException;
import br.com.spring.cache.demo.model.Billing;
import br.com.spring.cache.demo.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    BillingRepository billigRepo;


    public Billing findBillingById(String id) throws BillingNotFoundException {
        return billigRepo.findBillingById(id);
    }

    public List<Billing> findBillingAll() throws BillingNotFoundException {
        return billigRepo.findAll();
    }

    public void deleteBillingById(String id) throws BillingNotFoundException {
       billigRepo.deleteById(id);
    }

}
