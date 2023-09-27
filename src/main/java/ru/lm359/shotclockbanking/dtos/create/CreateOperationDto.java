package ru.lm359.shotclockbanking.dtos.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class CreateOperationDto {
    private Long accountId;
    private String transactionType;
    private String transactionStatus;
    private BigDecimal amount;
}
