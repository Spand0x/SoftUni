package com.spand0x.gamestore.services;


import com.spand0x.gamestore.domain.dtos.GameAddDto;
import com.spand0x.gamestore.domain.dtos.GameBasicDto;
import com.spand0x.gamestore.domain.dtos.GameDetailDto;
import com.spand0x.gamestore.domain.dtos.GameEditDto;

import java.util.Set;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    GameEditDto getGameById(long id);

    void editGame(GameEditDto gameDto,String[] values,long id);

    void deleteGame(long id);

    GameDetailDto getGameDetailByTitle(String title);

    Set<GameBasicDto> getAllGames();

    GameAddDto getGameByTitle(String title);
}
