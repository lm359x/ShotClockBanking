package ru.lm359.shotclockbanking.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lm359.shotclockbanking.models.Account;
import ru.lm359.shotclockbanking.models.Operation;
import ru.lm359.shotclockbanking.repo.OperationRepository;
import ru.lm359.shotclockbanking.service.AccountService;
import ru.lm359.shotclockbanking.service.OperationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    private final OperationRepository operationRepository;
    private final AccountService accountService;


    @Override
    public Operation createOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public Operation getOperationById(Long operationId) {
        return operationRepository.findById(operationId).orElse(null);
    }

    @Override
    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    @Override
    public Operation updateOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public void deleteOperation(Long operationId) {
        operationRepository.deleteById(operationId);
    }

    @Override
    public void confirmOperation(Operation operation) {
        Account updatedAccount = accountService.getAccountById(operation.getAccountId());
        updatedAccount.setBalance(updatedAccount.getBalance().add(operation.getAmount()));
        accountService.updateAccount(updatedAccount);
    }
}
