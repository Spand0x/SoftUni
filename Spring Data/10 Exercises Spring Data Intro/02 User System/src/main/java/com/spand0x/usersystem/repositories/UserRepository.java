package com.spand0x.usersystem.repositories;

import com.spand0x.usersystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Set<User> getUsersByEmailIsEndingWith(String emailProvider);
    Set<User> getUsersByLastTimeLoggedInAfter(LocalDateTime date);
    Set<User> getUsersByDeletedIsTrue();

}
