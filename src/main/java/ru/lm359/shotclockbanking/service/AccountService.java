package ru.lm359.shotclockbanking.service;

import ru.lm359.shotclockbanking.models.Account;

import java.util.List;


public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(Long accountId);
    List<Account> getAllAccounts();
    Account updateAccount(Account account);
    void deleteAccount(Long accountId);
}
