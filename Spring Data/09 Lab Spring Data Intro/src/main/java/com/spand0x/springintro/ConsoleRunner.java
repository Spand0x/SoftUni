package com.spand0x.springintro;

import com.spand0x.springintro.models.Account;
import com.spand0x.springintro.models.User;
import com.spand0x.springintro.services.AccountService;
import com.spand0x.springintro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("Pesho");
        user.setAge(20);
        user.setAccounts(new HashSet<>());

        Account account = new Account();
        account.setBalance(new BigDecimal(25000));
        account.setUser(user);

        user.getAccounts().add(account);

        userService.registerUser(user);
//        this.accountService.withdrawMoney(new BigDecimal(20000), account.getId());
        this.accountService.depositMoney(new BigDecimal(20000), account.getId());
    }
}
