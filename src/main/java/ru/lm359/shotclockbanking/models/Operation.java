package ru.lm359.shotclockbanking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "operations")
@Getter
@Setter
@NoArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;


    @Column(name="account_id")
    private Long accountId;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Column(name="transaction_status", nullable = false)
    private String transactionStatus;

    @Column(name = "amount", precision = 18, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "transaction_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    public Operation(Long accountId, String transactionType, BigDecimal amount, String transactionStatus, Date transactionDate) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionStatus = transactionStatus;
        this.transactionDate = transactionDate;
    }
}
