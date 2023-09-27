package ru.lm359.shotclockbanking.controller;

import org.springframework.web.bind.annotation.*;
import ru.lm359.shotclockbanking.controller.exception.NotFoundException;
import ru.lm359.shotclockbanking.dtos.create.CreateOperationDto;
import ru.lm359.shotclockbanking.dtos.update.UpdateOperationDto;
import ru.lm359.shotclockbanking.models.Account;
import ru.lm359.shotclockbanking.models.Operation;
import ru.lm359.shotclockbanking.service.AccountService;
import ru.lm359.shotclockbanking.service.OperationService;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/operations")
public class OperationController {
    private final OperationService operationService;
    private final AccountService accountService;

    public OperationController(OperationService operationService, AccountService accountService) {
        this.operationService = operationService;
        this.accountService = accountService;
    }

    @PostMapping
    public Operation createOperation(@RequestBody CreateOperationDto operationDto){
        Account account = accountService.getAccountById(operationDto.getAccountId());
        if(account==null)
            throw new NotFoundException("Account not found");
        Operation operation = new Operation(
                operationDto.getAccountId(),
                operationDto.getTransactionType(),
                operationDto.getAmount(),
                operationDto.getTransactionStatus(),
                new Date()
        );
        if(operation.getTransactionStatus().equals("CONFIRMED"))
            operationService.confirmOperation(operation);
        return operationService.createOperation(operation);
    }

    @GetMapping("/{operationId}")
    public Operation getOperationById(@PathVariable Long operationId){
        return operationService.getOperationById(operationId);
    }

    @GetMapping
    public List<Operation> getAllOperations(){
        return operationService.getAllOperations();
    }

    @PutMapping("/{operationId}")
    public Operation updateOperation(@PathVariable Long operationId, @RequestBody UpdateOperationDto operationDto){
        Operation existingOperation = operationService.getOperationById(operationId);
        if(existingOperation==null)
            throw new NotFoundException("Operation not found");
        if(operationDto.getTransactionStatus()!=null){
            if(Objects.equals(operationDto.getTransactionStatus(), "CONFIRMED")
                    &&!Objects.equals(existingOperation.getTransactionStatus(),"CONFIRMED"))
                operationService.confirmOperation(existingOperation);
            existingOperation.setTransactionStatus(operationDto.getTransactionStatus());
        }
        return operationService.updateOperation(existingOperation);
    }
}
