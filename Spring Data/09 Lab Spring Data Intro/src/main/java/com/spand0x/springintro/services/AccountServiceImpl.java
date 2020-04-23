package com.spand0x.springintro.services;

import com.spand0x.springintro.models.Account;
import com.spand0x.springintro.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Account current = this.accountRepository.findAccountById(id);
        if(current.getBalance().compareTo(money)<0){
            throw new IllegalArgumentException("Not enough money");
        }
        current.setBalance(current.getBalance().subtract(money));
        this.accountRepository.saveAndFlush(current);
    }

    @Override
    public void depositMoney(BigDecimal money, Long id) {
        Account current = this.accountRepository.findAccountById(id);
        if(current == null){
            throw new IllegalArgumentException("Account does not exists");
        }
        current.setBalance(current.getBalance().add(money));
        this.accountRepository.saveAndFlush(current);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {

    }
}
