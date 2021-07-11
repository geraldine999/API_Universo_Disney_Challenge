package com.example.api_universo_disney_challenge.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmovie;
    private String image;
    private String title;
    private Integer yearofrelease;
    private Integer score;

    @JsonBackReference
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Character> characters;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Genre> genres;

    public Movie() {
    }

    public Movie(String image, String title, Integer yearofrelease, Integer score, List<Character> characters, List<Genre> genres) {
        this.image = image;
        this.title = title;
        this.yearofrelease = yearofrelease;
        this.score = score;
        this.characters = characters;
        this.genres = genres;
    }

    public Movie(Integer idmovie, String image, String title, Integer yearofrelease, Integer score, List<Character> characters, List<Genre> genres) {
        this.idmovie = idmovie;
        this.image = image;
        this.title = title;
        this.yearofrelease = yearofrelease;
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

    public Integer getYearofrelease() {
        return yearofrelease;
    }

    public void setYearofrelease(Integer yearOfRelease) {
        this.yearofrelease = yearOfRelease;
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
                ", yearOfRelease=" + yearofrelease +
                ", score=" + score +
                ", characters=" + characters +
                ", genres=" + genres +
                '}';
    }
}
