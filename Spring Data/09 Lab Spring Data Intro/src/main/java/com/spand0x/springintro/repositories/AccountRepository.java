package com.spand0x.springintro.repositories;

import com.spand0x.springintro.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountById(Long id);
}
