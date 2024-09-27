package net.ayoub.accountservice.web;

import lombok.AllArgsConstructor;
import net.ayoub.accountservice.clients.CustomerRestClient;
import net.ayoub.accountservice.entities.BankAccount;
import net.ayoub.accountservice.model.Customer;
import net.ayoub.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accounts = accountRepository.findAll();
        Customer customer;
        for(BankAccount account : accounts){
            customer = customerRestClient.findCustomerById(account.getCustomerId());
            account.setCustomer(customer);
        }
        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getAccountById(@PathVariable(name = "id") String id){
        BankAccount bankAccount = accountRepository.findById(id).orElse(null);
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
