package br.com.spring.cache.demo;

import br.com.spring.cache.demo.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = BillingRepository.class)
@EnableCaching
public class AccountManagerApplication {

	@Autowired
	BillingRepository billingRepo;

	public static void main(String[] args) {
		SpringApplication.run(AccountManagerApplication.class, args);
	}

}
