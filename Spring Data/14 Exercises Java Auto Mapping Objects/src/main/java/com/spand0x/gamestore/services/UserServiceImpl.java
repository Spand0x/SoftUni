package com.spand0x.gamestore.services;

import com.spand0x.gamestore.domain.dtos.GameAddDto;
import com.spand0x.gamestore.domain.dtos.UserLoginDto;
import com.spand0x.gamestore.domain.dtos.UserRegisterDto;
import com.spand0x.gamestore.domain.entities.Game;
import com.spand0x.gamestore.domain.entities.Order;
import com.spand0x.gamestore.domain.entities.Role;
import com.spand0x.gamestore.domain.entities.User;
import com.spand0x.gamestore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private UserLoginDto userLoginDto;
    private final OrderService orderService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, OrderService orderService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = this.modelMapper.map(userRegisterDto, User.class);
        user.setRole(this.userRepository.count() == 0 ? Role.ADMIN : Role.USER);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        if (this.userLoginDto == null) {
            User user = userRepository.findByEmail(userLoginDto.getEmail());
            if (user == null) {
                System.out.println("User is not registered");
            } else {
                if (user.getEmail().equals(userLoginDto.getEmail()) &&
                        user.getPassword().equals(userLoginDto.getPassword())) {
                    this.userLoginDto = userLoginDto;
                    System.out.printf("Successfully logged in %s%n", user.getFullName());
                    return;
                }
                System.out.println("Incorrect username / password");
            }
        } else {
            System.out.println("There is a logged in user");
        }


    }

    @Override
    public void logout() {
        if (this.userLoginDto == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }
        String fullName = userRepository.findByEmail(this.userLoginDto.getEmail()).getFullName();
        System.out.printf("User %s successfully logged out%n", fullName);
        this.userLoginDto = null;
    }

    @Override
    public boolean isUserAdmin() {
        if (this.userLoginDto != null) {
            User user = this.userRepository.findByEmail(userLoginDto.getEmail());
            return user.getRole().equals(Role.ADMIN);
        }
        System.out.println("No logged in user");
        return false;
    }

    @Override
    public void addGameToOrder(GameAddDto gameAddDto) {
        String userEmail = this.userLoginDto.getEmail();
        User user = this.userRepository.findByEmail(userEmail);
        Game game = this.modelMapper.map(gameAddDto, Game.class);
        Order order = new Order();
        order.setBuyer(user);
        order.getProducts().add(game);
        this.orderService.save(order);
    }

    @Override
    public boolean isUserLoggedIn() {
        return this.userLoginDto != null;
    }
}
