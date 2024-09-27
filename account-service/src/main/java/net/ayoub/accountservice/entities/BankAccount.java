package net.ayoub.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.ayoub.accountservice.enums.AccountType;
import net.ayoub.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String accountNumber;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    //foreign key
    @Transient
    private Customer customer;
    private Long customerId;
}
