package br.com.spring.cache.demo;

import br.com.spring.cache.demo.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableCaching
@EnableMongoRepositories(basePackageClasses = BillingRepository.class)
public class AccountManagerApplication {

	@Autowired
	BillingRepository billingRepo;

	public static void main(String[] args) {
		SpringApplication.run(AccountManagerApplication.class, args);
	}

}
