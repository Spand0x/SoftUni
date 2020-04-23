package com.spand0x.springintro.services;

import com.spand0x.springintro.models.User;
import com.spand0x.springintro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        if(this.userRepository.getByUsername(user.getUsername()) != null){
            System.out.println("User exists");
        }else {
            this.userRepository.saveAndFlush(user);
        }

    }
}
