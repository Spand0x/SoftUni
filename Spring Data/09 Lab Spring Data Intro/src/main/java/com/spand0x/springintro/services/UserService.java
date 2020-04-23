package com.spand0x.springintro.services;

import com.spand0x.springintro.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(User user);
}
