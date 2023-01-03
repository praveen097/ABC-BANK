package edu.abcbank.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("edu.abcbank.model")
@EnableJpaRepositories("edu.abcbank.repository")
@ComponentScan("edu.abcbank")
public class AbcBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcBankApplication.class, args);
	}

}
