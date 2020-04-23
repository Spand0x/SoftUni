package com.spand0x.gamestore.services;


import com.spand0x.gamestore.domain.dtos.GameAddDto;
import com.spand0x.gamestore.domain.dtos.UserLoginDto;
import com.spand0x.gamestore.domain.dtos.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean isUserAdmin();

    void addGameToOrder(GameAddDto gameAddDto);

    boolean isUserLoggedIn();
}
