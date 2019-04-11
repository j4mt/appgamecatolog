package com.j4mt.app.gamecatolog.web;

import com.j4mt.app.gamecatolog.model.Game;
import com.j4mt.app.gamecatolog.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class CatalogController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<Game> getAllGames() {

        return gameRepository.findAll();
    }
}
