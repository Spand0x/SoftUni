package com.spand0x.gamestore.repositories;

import com.spand0x.gamestore.domain.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
        Game findGameById(Long id);

        Game findGameByTitle(String title);

        Set<Game> getAllByIdNotNull();
}
