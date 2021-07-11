package com.example.api_universo_disney_challenge.services;

import com.example.api_universo_disney_challenge.entities.Character;
import com.example.api_universo_disney_challenge.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Map<String, String> findAll() {
        List<Character> personajes = characterRepository.findAll();
        Map<String, String> nombresEImagenes = new HashMap<>();
            for (Character p: personajes) {
                nombresEImagenes.put(p.getName(), p.getImage());
            }
            return nombresEImagenes;

            }



    public void save(Character personaje) {
         characterRepository.save(personaje);
    }

    public void deleteById(Integer id) {
        characterRepository.deleteById(id);
    }



    public Character findById(Integer id) {
        return characterRepository.findById(id).orElse(null);
    }

    public Optional<Character> getCharacterByName(String name) {
        return characterRepository.getCharacterByName(name);
    }

    public Optional<List<Character>> getCharactersByWeight(Double weight) {
        return characterRepository.getCharactersByWeight(weight);
    }

    public List<Character> getAll() {
        return characterRepository.findAll();
    }
}
