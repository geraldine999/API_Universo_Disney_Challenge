package com.example.api_universo_disney_challenge.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="characters")
public class Character {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idcharacter;
    private String image;
    private String name;
    private Integer age;
    private Double weight;
    private String story;

    @JsonManagedReference //no agrega objetos child personaje
    @ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="characters_x_movies",
        joinColumns = @JoinColumn(name="idcharacter"),
            inverseJoinColumns = @JoinColumn(name="idmovie")
    )
    private List<Movie> movies;

    public Character() {
    }

    public Character(String image, String name, Integer age, Double weight, String story) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.story = story;
    }

    public Character(String image, String name, Integer age, Double weight, String story, List<Movie>movies) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.story = story;
        this.movies = movies;
    }

    public Character(Integer idcharacter, String image, String name, Integer age, Double weight, String story, List<Movie> movies) {
        this.idcharacter = idcharacter;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.story = story;
        this.movies = movies;
    }

    public Integer getIdcharacter() {
        return idcharacter;
    }

    public void setIdcharacter(Integer idcharacter) {
        this.idcharacter = idcharacter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String history) {
        this.story = history;
    }

    public List <Movie> getMovies() {
        return movies;
    }

    public void setMovies(List <Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Character{" +
                "idcharacter=" + idcharacter +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", story='" + story + '\'' +
                ", movies='" + movies + '\'' +
                '}';
    }
}
