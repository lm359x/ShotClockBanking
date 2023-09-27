package ru.lm359.shotclockbanking.service;

import ru.lm359.shotclockbanking.models.Deposit;

import java.util.List;

public interface DepositService {
    Deposit createDeposit(Deposit deposit);
    Deposit getDepositById(Long depositId);
    List<Deposit> getAllDeposits();
    Deposit updateDeposit(Deposit deposit);
    void deleteDeposit(Long depositId);
}
