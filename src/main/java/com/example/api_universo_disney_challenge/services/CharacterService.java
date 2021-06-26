package com.example.api_universo_disney_challenge.services;

import com.example.api_universo_disney_challenge.entities.Character;
import com.example.api_universo_disney_challenge.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }
}
