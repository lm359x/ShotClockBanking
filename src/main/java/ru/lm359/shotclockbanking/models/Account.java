package ru.lm359.shotclockbanking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "account_number", nullable = false)
    private Integer accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "balance", precision = 18, scale = 2)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Customer owner;

    @Column(name = "monthly_payment", precision = 18, scale = 2)
    private BigDecimal monthlyPayment;

    public Account(Integer accountNumber, String accountType, BigDecimal balance, Customer owner, BigDecimal monthlyPayment) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.owner = owner;
        this.monthlyPayment = monthlyPayment;
    }
}
