package com.spand0x.gamestore.services;

import com.spand0x.gamestore.domain.dtos.GameAddDto;
import com.spand0x.gamestore.domain.dtos.GameBasicDto;
import com.spand0x.gamestore.domain.dtos.GameDetailDto;
import com.spand0x.gamestore.domain.dtos.GameEditDto;
import com.spand0x.gamestore.domain.entities.Game;
import com.spand0x.gamestore.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public GameServiceImpl(GameRepository gameRepository, UserService userService, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        if (this.userService.isUserAdmin()) {
            Game game = this.modelMapper.map(gameAddDto, Game.class);
            this.gameRepository.saveAndFlush(game);
            return;
        }
        System.out.println("User is not admin");
    }

    @Override
    public GameEditDto getGameById(long id) {
        if (this.userService.isUserAdmin()) {
            Game game = this.gameRepository.findGameById(id);
            if (game == null) {
                System.out.println("Game not found");
                return null;
            }
            return this.modelMapper.map(game, GameEditDto.class);

        }
        System.out.println("User is not admin");
        return null;
    }

    @Override
    public void editGame(GameEditDto gameDto,String[] values,long id) {
        if(!this.userService.isUserAdmin()){
            System.out.println("User is not admin");
            return;
        }
        Game game = this.gameRepository.findGameById(id);
        for (String value : values) {
            String category = value.split("=")[0];
            String catValue = value.split("=")[1];
            switch (category){
                case "title":
                    gameDto.setTitle(catValue);
                    break;
                case "trailer":
                    gameDto.setTrailer(catValue);
                    break;
                case "image":
                    gameDto.setImage(catValue);
                    break;
                case "size":
                    gameDto.setSize(Double.parseDouble(catValue));
                    break;
                case "price":
                    gameDto.setPrice(new BigDecimal(catValue));
                    break;
                case "description":
                    gameDto.setDescription(catValue);
                    break;
                case "releaseDate":
                    gameDto.setReleaseDate(LocalDate.parse(catValue, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    break;
                default:

                    break;
            }
        }
        game = this.modelMapper.map(gameDto,Game.class);
        this.gameRepository.saveAndFlush(game);


    }


    @Override
    public void deleteGame(long id) {
        if (this.userService.isUserAdmin()) {
            Game game = this.gameRepository.findGameById(id);
            if (game == null) {
                System.out.println("Game not found");
                return;
            }
            this.gameRepository.delete(game);
            System.out.println("Deleted " + game.getTitle());
            return;
        }
        System.out.println("User is not admin");
    }

    @Override
    public GameDetailDto getGameDetailByTitle(String title) {
        Game game = this.gameRepository.findGameByTitle(title);
        return this.modelMapper.map(game,GameDetailDto.class);
    }

    @Override
    public Set<GameBasicDto> getAllGames() {
        Set<Game> games = this.gameRepository.getAllByIdNotNull();
        return games.stream().map(game-> this.modelMapper.map(game, GameBasicDto.class)).collect(Collectors.toSet());
    }

    @Override
    public GameAddDto getGameByTitle(String title) {
        Game game = this.gameRepository.findGameByTitle(title);
        return modelMapper.map(game,GameAddDto.class);
    }
}
