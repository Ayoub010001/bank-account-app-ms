package net.ayoub.customerservice;

import net.ayoub.customerservice.entities.Customer;
import net.ayoub.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CustomerRepository customerRepository) {
		return args -> {
			//we can make a list of customers and use save all;
			customerRepository.save(new Customer(null,"aub","ritoub","e@e.com"));
			customerRepository.save(new Customer(null,"yahya","ritoub","e@e.com"));
			customerRepository.save(new Customer(null,"stable","zee","e@e.com"));
		};
	}
}
