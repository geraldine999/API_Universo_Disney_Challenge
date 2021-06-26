package com.example.api_universo_disney_challenge.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genres")
public class Genre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgenre;
    private String name;
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="genres_x_movies",
    joinColumns = @JoinColumn(name="idgenre"),
            inverseJoinColumns = @JoinColumn(name="idmovie")
    )
    private List<Movie> movies;

    public Genre() {
    }

    public Genre(String name, String image, List<Movie> movies) {
        this.name = name;
        this.image = image;
        this.movies = movies;
    }

    public Genre(Integer idgenre, String name, String image, List<Movie> movies) {
        this.idgenre = idgenre;
        this.name = name;
        this.image = image;
        this.movies = movies;
    }

    public Integer getIdgenre() {
        return idgenre;
    }

    public void setIdgenre(Integer idgenre) {
        this.idgenre = idgenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "idgenre=" + idgenre +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", movies=" + movies +
                '}';
    }
}
