package ru.lm359.shotclockbanking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "deposits")
@Getter
@Setter
@NoArgsConstructor
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deposit_id")
    private Long depositId;

    @Column(name = "deposit_number", nullable = false)
    private Integer depositNumber;

    @Column(name = "balance", precision = 18, scale = 2)
    private BigDecimal balance;

    @Column(name = "interest_rate", precision = 5, scale = 2)
    private BigDecimal interestRate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Customer owner;

    public Deposit(Integer depositNumber, BigDecimal balance, BigDecimal interestRate, Customer owner) {
        this.depositNumber = depositNumber;
        this.balance = balance;
        this.interestRate = interestRate;
        this.owner = owner;
    }
}
