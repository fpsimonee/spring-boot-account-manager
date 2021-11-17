package br.com.spring.cache.demo.service;

import br.com.spring.cache.demo.exception.BillingNotFoundException;
import br.com.spring.cache.demo.model.Billing;
import br.com.spring.cache.demo.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    BillingRepository billigRepo;


    @Cacheable("billingCache")
    public Billing findBillingById(String id) throws BillingNotFoundException {
        return billigRepo.findBillingById(id);
    }

    public List<Billing> findBillingAll() throws BillingNotFoundException {
        return billigRepo.findAll();
    }

    public void deleteBillingById(String id) throws BillingNotFoundException {
       billigRepo.deleteById(id);
    }


    public Billing insertBilling(Billing billing) throws BillingNotFoundException {
        return billigRepo.save(billing);
    }
  
    public Billing update(String id, Billing billing) throws BillingNotFoundException {
        Billing dbBilling = findBillingById(id);

        dbBilling.merge(billing);

        return billigRepo.save(dbBilling);
    }

    public List<Billing> insertAll(List<Billing> billing) throws BillingNotFoundException {
        return billigRepo.insert(billing);
    }

}
