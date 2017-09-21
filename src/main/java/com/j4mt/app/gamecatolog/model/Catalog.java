package com.j4mt.app.gamecatolog.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CATALOG")
public class Catalog {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    @JoinTable(name = "USER_ID")
    private User user;

    @OneToMany
    @JoinTable(name = "USER_GAME")
    private Set<Game> games;

    public void addGame(Game game, User user) {

        if (games == null)
            games = new HashSet<Game>();

        games.add(game);
        game.addUser(user);
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
