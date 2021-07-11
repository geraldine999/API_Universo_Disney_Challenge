package com.example.api_universo_disney_challenge.repositories;

import com.example.api_universo_disney_challenge.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {



    Optional<Character> getCharacterByName(String name);

    Optional<List<Character>> getCharactersByWeight(Double weight);


}
