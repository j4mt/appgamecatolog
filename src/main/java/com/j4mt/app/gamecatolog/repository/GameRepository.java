package com.j4mt.app.gamecatolog.repository;

import com.j4mt.app.gamecatolog.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
