package ru.lm359.shotclockbanking.dtos.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class CreateAccountDto {
    private Integer accountNumber;
    private String accountType;
    private BigDecimal balance;
    private Long ownerId;
    private BigDecimal monthlyPayment;
}
