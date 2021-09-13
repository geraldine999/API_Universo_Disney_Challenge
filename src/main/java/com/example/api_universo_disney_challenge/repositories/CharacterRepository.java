package com.example.api_universo_disney_challenge.repositories;

import com.example.api_universo_disney_challenge.entities.Character;
import com.example.api_universo_disney_challenge.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {



    Optional<Character> getCharacterByName(String name);

    Optional<List<Character>> getCharactersByWeight(Double weight);


    List<Character> findCharactersByNameContainingAndAgeEqualsAndMoviesContaining(String s, Integer integer, Movie movie);

    List<Character> findCharactersByNameContainingAndMoviesContaining(String s, Movie movie);

    List<Character> findCharactersByAgeEqualsAndMoviesContaining(Integer integer, Movie movie);

    List<Character> findCharactersByMoviesContaining(Movie movie);

    List<Character> findCharactersByNameContainingAndAgeEquals(String s, Integer integer);

    List<Character> findCharactersByNameContaining(String s);

    List<Character> findCharactersByAgeEquals(Integer integer);

}
