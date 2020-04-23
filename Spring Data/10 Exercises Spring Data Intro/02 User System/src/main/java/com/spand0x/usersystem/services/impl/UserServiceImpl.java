package com.spand0x.usersystem.services.impl;

import com.spand0x.usersystem.entities.User;
import com.spand0x.usersystem.repositories.UserRepository;
import com.spand0x.usersystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> getUsersByEmailProvider(String emailProvider) {
        return userRepository.getUsersByEmailIsEndingWith(emailProvider);
    }

    @Override
    public long getUsersCount() {
        return this.userRepository.count();
    }

    @Override
    public void save(User user) {
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public long markForDeleteUsers(LocalDateTime date) {
        Set<User> users = this.userRepository.getUsersByLastTimeLoggedInAfter(date);
        users.forEach(u->{
            u.setDeleted(true);
            this.userRepository.saveAndFlush(u);
        });
        return users.size();
    }

    @Override
    public void deleteUsers() {
        this.userRepository.getUsersByDeletedIsTrue().forEach(this.userRepository::delete);
    }
}
