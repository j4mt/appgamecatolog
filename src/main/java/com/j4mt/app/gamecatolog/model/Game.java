package com.j4mt.app.gamecatolog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GAME")
public class Game {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DEVELOPER")
    private String developer;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "RELEASE_YEAR")
    private String releaseYear;

    @Column(name = "COPIES")
    private int copies;

    @Column(name = "PIRATE_COPY")
    private boolean pirateCopy;

    @ManyToMany(mappedBy = "games")
    private Set<User> users;

    public Game() {
    }

    public Game(String name, String developer, String publisher, String releaseYear, int copies, boolean pirateCopy) {

        this.name = name;
        this.developer = developer;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.copies = copies;
        this.pirateCopy = pirateCopy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public boolean isPirateCopy() {
        return pirateCopy;
    }

    public void setPirateCopy(boolean pirateCopy) {
        this.pirateCopy = pirateCopy;
    }

    public void addUser(User user) {

        if (users == null)
            users = new HashSet<User>();

        users.add(user);
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
