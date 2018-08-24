package com.j4mt.app.gamecatolog.repository;

import com.j4mt.app.gamecatolog.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GameRepository extends JpaRepository<Game, Long> {
}
