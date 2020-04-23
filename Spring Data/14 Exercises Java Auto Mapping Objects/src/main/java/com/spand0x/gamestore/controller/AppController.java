package com.spand0x.gamestore.controller;

import com.spand0x.gamestore.domain.dtos.*;
import com.spand0x.gamestore.services.GameService;
import com.spand0x.gamestore.services.UserService;
import com.spand0x.gamestore.utils.ValidationUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;

@Component
public class AppController implements CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;
    private final ValidationUtil validationUtil;

    public AppController(BufferedReader bufferedReader, UserService userService, GameService gameService, ValidationUtil validationUtil) {
        this.bufferedReader = bufferedReader;
        this.userService = userService;
        this.gameService = gameService;
        this.validationUtil = validationUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Enter command or write Exit:");
            String[] input = this.bufferedReader.readLine().split("\\|");
            switch (input[0]) {
                case "RegisterUser":
                    registerUser(input);
                    break;
                case "LoginUser":
                    loginUser(input);
                    break;
                case "Logout":
                    this.userService.logout();
                    break;
                case "AddGame":
                    addGame(input);
                    break;
                case "EditGame":
                    editGame(input);
                    break;
                case "DeleteGame":
                    deleteGame(input);
                    break;
                case "AllGames":
                    printAllGames();
                    break;
                case "DetailGame":
                    printGameDetail(input[1]);
                    break;
                case "OwnedGames":
                    //todo
                    break;
                case "AddItem":
//                    addItem(input[1]);
                    break;
                case "RemoveItem":

                    break;
                case "BuyItem":

                    break;
                case "Exit":
                    return;
            }
        }

    }

    private void addItem(String gameTitle) {
        GameAddDto game = this.gameService.getGameByTitle(gameTitle);
        if(game == null){
            System.out.println("Game not found");
            return;
        }
        if(!this.userService.isUserLoggedIn()){
            System.out.println("No logged in user");
            return;
        }
        this.userService.addGameToOrder(game);
    }

    private void printGameDetail(String gameTitle) {
        GameDetailDto game = this.gameService.getGameDetailByTitle(gameTitle);
        System.out.printf("Title: %s%n" +
                "Price: %s%n" +
                "Description: %s%n" +
                "Release Date: %s%n",game.getTitle(),game.getPrice(),game.getDescription(),game.getReleaseDate());
    }

    private void printAllGames() {
        Set<GameBasicDto> allGames = this.gameService.getAllGames();
        allGames.forEach(game-> System.out.printf("%s %s%n",game.getTitle(),game.getPrice()));
    }

    private void deleteGame(String[] input) {
        this.gameService.deleteGame(Long.parseLong(input[2]));
    }

    private void editGame(String[] input) {
        long id = Long.parseLong(input[1]);
        GameEditDto game = this.gameService.getGameById(Long.parseLong(input[1]));
        String[] values = Arrays.stream(input).skip(2).toArray(String[]::new);
        this.gameService.editGame(game,values,id);
        System.out.println("Edited " + game.getTitle());
    }

    private void addGame(String[] input) {
        GameAddDto game = new GameAddDto(input[1],
                new BigDecimal(input[2]),
                Double.parseDouble(input[3]),
                input[4],input[5],input[6],
                LocalDate.parse(input[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        this.gameService.addGame(game);
    }

    private void loginUser(String[] input) {
        UserLoginDto userLoginDto = new UserLoginDto(input[1], input[2]);
        this.userService.loginUser(userLoginDto);
    }

    private void registerUser(String[] input) {
        if (!input[2].equals(input[3])) {
            System.out.println("Password doesn't match.");
            return;
        }
        UserRegisterDto userRegisterDto = new UserRegisterDto(input[1], input[2], input[4]);

        if (validationUtil.isValid(userRegisterDto)) {
            this.userService.registerUser(userRegisterDto);
        } else {
            validationUtil.getViolations(userRegisterDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }

    }
}
