package ru.lm359.shotclockbanking.dtos.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class CreateDepositDto {
    private Integer depositNumber;
    private BigDecimal balance;
    private BigDecimal interestRate;
    private Long ownerId;
}
