package fr.iut.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.iut.banking.services.AccountService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories(basePackages = "fr.iut.banking.repository")
@EntityScan(basePackages = "fr.iut.banking.entities")
public class BankingApplication {
	AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }
}
