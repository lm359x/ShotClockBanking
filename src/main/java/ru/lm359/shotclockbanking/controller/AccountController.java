package ru.lm359.shotclockbanking.controller;


import org.springframework.web.bind.annotation.*;
import ru.lm359.shotclockbanking.controller.exception.NotFoundException;
import ru.lm359.shotclockbanking.dtos.create.CreateAccountDto;
import ru.lm359.shotclockbanking.models.Account;
import ru.lm359.shotclockbanking.models.Customer;
import ru.lm359.shotclockbanking.service.AccountService;
import ru.lm359.shotclockbanking.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {
    private final AccountService accountService;
    private final CustomerService customerService;

    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }
    @PostMapping
    public Account createAccount(@RequestBody CreateAccountDto accountDto) {
        Customer customer = customerService.getCustomerById(accountDto.getOwnerId());
        if(customer==null)
            throw new NotFoundException("Customer not found");
        Account account = new Account(
                accountDto.getAccountNumber(),
                accountDto.getAccountType(),
                accountDto.getBalance(),
                customer,
                accountDto.getMonthlyPayment()
        );
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @GetMapping
    public List<Account> getAllCustomers() {
        return accountService.getAllAccounts();
    }

    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable Long accountId, @RequestBody Account updatedAccount) {
        Account existingAccount = accountService.getAccountById(accountId);
        if(existingAccount==null)
            throw new NotFoundException("Customer not found");
        if(updatedAccount.getAccountType()!=null)
            existingAccount.setAccountType(updatedAccount.getAccountType());
        if(updatedAccount.getBalance()!=null)
            existingAccount.setBalance(updatedAccount.getBalance());
        if(updatedAccount.getMonthlyPayment()!=null)
            existingAccount.setMonthlyPayment(updatedAccount.getMonthlyPayment());

        return accountService.updateAccount(existingAccount);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
    }

}
