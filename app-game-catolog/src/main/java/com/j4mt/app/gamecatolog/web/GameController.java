package com.j4mt.app.gamecatolog.web;

import com.j4mt.app.gamecatolog.model.Game;
import com.j4mt.app.gamecatolog.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gameRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGame(@RequestBody Game game) {

        gameRepository.save(game);
    }


    @GetMapping
    public List<Game> getAllGames() {

        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {

        Optional<Game> game = gameRepository.findById(id);
        if (!game.isPresent())
            throw new ResourceNotFoundException("Game not found");
        return game.get();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Long id) {

        gameRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateGame(@PathVariable Long id, @RequestBody Game game) {
        game.setId(id);
        gameRepository.save(game);
    }
}
