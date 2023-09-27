package ru.lm359.shotclockbanking.service;

import ru.lm359.shotclockbanking.models.Operation;

import java.util.List;

public interface OperationService {
    Operation createOperation(Operation operation);
    Operation getOperationById(Long operationId);
    List<Operation> getAllOperations();
    Operation updateOperation(Operation operation);
    void deleteOperation(Long operationId);

    void confirmOperation(Operation operation);
}
