package com.spand0x.usersystem.services;

import com.spand0x.usersystem.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Service
public interface UserService {
    Set<User> getUsersByEmailProvider(String emailProvider);

    long getUsersCount();

    void save(User user);

    long markForDeleteUsers(LocalDateTime date);

    void deleteUsers();
}
