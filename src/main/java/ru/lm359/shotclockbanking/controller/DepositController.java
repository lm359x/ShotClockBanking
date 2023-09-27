package ru.lm359.shotclockbanking.controller;

import org.springframework.web.bind.annotation.*;
import ru.lm359.shotclockbanking.controller.exception.NotFoundException;
import ru.lm359.shotclockbanking.dtos.create.CreateDepositDto;
import ru.lm359.shotclockbanking.models.Customer;
import ru.lm359.shotclockbanking.models.Deposit;
import ru.lm359.shotclockbanking.service.CustomerService;
import ru.lm359.shotclockbanking.service.DepositService;

import java.util.List;

@RestController
@RequestMapping("/v1/deposits")
public class DepositController {
    private final DepositService depositService;
    private final CustomerService customerService;

    public DepositController(CustomerService customerService, DepositService depositService) {
        this.depositService = depositService;
        this.customerService = customerService;
    }
    @PostMapping
    public Deposit createDeposit(@RequestBody CreateDepositDto depositDto) {
        Customer customer = customerService.getCustomerById(depositDto.getOwnerId());
        if(customer==null)
            throw new NotFoundException("Customer not found");
        Deposit deposit = new Deposit(
                depositDto.getDepositNumber(),
                depositDto.getBalance(),
                depositDto.getInterestRate(),
                customer);
        return depositService.createDeposit(deposit);
    }

    @GetMapping("/{depositId}")
    public Deposit getDepositById(@PathVariable Long depositId) {
        return depositService.getDepositById(depositId);
    }

    @GetMapping
    public List<Deposit> getAllDeposits() {
        return depositService.getAllDeposits();
    }

    @PutMapping("/{depositId}")
    public Deposit updateDeposit(@PathVariable Long depositId, @RequestBody Deposit updatedDeposit) {
        Deposit existingDeposit = depositService.getDepositById(depositId);
        if(existingDeposit==null)
            throw new NotFoundException("Deposit not found");
        if(updatedDeposit.getBalance()!=null)
            existingDeposit.setBalance(updatedDeposit.getBalance());
        if(updatedDeposit.getInterestRate()!=null)
            existingDeposit.setInterestRate(updatedDeposit.getInterestRate());
        return depositService.updateDeposit(existingDeposit);
    }

    @DeleteMapping("/{depositId}")
    public void deleteDeposit(@PathVariable Long depositId) {
        depositService.deleteDeposit(depositId);
    }

}
