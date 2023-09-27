package ru.lm359.shotclockbanking.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lm359.shotclockbanking.models.Deposit;
import ru.lm359.shotclockbanking.repo.DepositRepository;
import ru.lm359.shotclockbanking.service.DepositService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {
    private final DepositRepository depositRepository;

    @Override
    public Deposit createDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Override
    public Deposit getDepositById(Long depositId) {
        return depositRepository.findById(depositId).orElse(null);
    }

    @Override
    public List<Deposit> getAllDeposits() {
        return depositRepository.findAll();
    }

    @Override
    public Deposit updateDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Override
    public void deleteDeposit(Long depositId) {
        depositRepository.deleteById(depositId);
    }
}
