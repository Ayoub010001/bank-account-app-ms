package net.ayoub.accountservice;

import net.ayoub.accountservice.clients.CustomerRestClient;
import net.ayoub.accountservice.entities.BankAccount;
import net.ayoub.accountservice.enums.AccountType;
import net.ayoub.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
        return args -> {

            customerRestClient.findAllCustomers().forEach(c -> {
                BankAccount bankAccount = BankAccount.builder().accountNumber(UUID.randomUUID().toString()).currency("MAD")
                        .balance(Math.random() * 90000).createdAt(LocalDate.now()).type(AccountType.CURRENT_ACCOUNT)
                        .customerId(1L)
                        .build();
                BankAccount bankAccount1 = BankAccount.builder().accountNumber(UUID.randomUUID().toString()).currency("MAD")
                        .balance(Math.random() * 3000).createdAt(LocalDate.now()).type(AccountType.CURRENT_ACCOUNT)
                        .customerId(2L)
                        .build();
                bankAccountRepository.save(bankAccount);
                bankAccountRepository.save(bankAccount1);
            });
        };
    }
}
