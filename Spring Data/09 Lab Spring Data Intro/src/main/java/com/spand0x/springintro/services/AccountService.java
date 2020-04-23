package com.spand0x.springintro.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface AccountService {
    void withdrawMoney(BigDecimal money,Long id);
    void depositMoney(BigDecimal money,Long id);
    void transferMoney(BigDecimal money,Long id);
}
