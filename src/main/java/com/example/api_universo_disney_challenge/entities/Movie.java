package com.example.api_universo_disney_challenge.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmovie;
    private String image;
    private String title;
    private Integer yearOfRelease;
    private Integer score;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Character> characters;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Genre> genres;

    public Movie() {
    }

    public Movie(String image, String title, Integer yearOfRelease, Integer score, List<Character> characters, List<Genre> genres) {
        this.image = image;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.score = score;
        this.characters = characters;
        this.genres = genres;
    }

    public Movie(Integer idmovie, String image, String title, Integer yearOfRelease, Integer score, List<Character> characters, List<Genre> genres) {
        this.idmovie = idmovie;
        this.image = image;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.score = score;
        this.characters = characters;
        this.genres = genres;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public Integer getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(Integer idmovie) {
        this.idmovie = idmovie;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "idmovie=" + idmovie +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", score=" + score +
                ", characters=" + characters +
                ", genres=" + genres +
                '}';
    }
}
