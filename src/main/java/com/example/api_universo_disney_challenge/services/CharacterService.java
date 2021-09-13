package com.example.api_universo_disney_challenge.services;

import com.example.api_universo_disney_challenge.entities.Character;
import com.example.api_universo_disney_challenge.entities.Movie;
import com.example.api_universo_disney_challenge.repositories.CharacterRepository;
import com.example.api_universo_disney_challenge.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }

    public Map<String, String> findAll() {
        List<Character> personajes = characterRepository.findAll();
        Map<String, String> nombresEImagenes = new HashMap<>();
            for (Character p: personajes) {
                nombresEImagenes.put(p.getName(), p.getImage());
            }
            return nombresEImagenes;

            }



    public Character save(Character personaje) {
        if(personaje.getIdcharacter()!=null) {
            Character personajeExistente = characterRepository.findById(personaje.getIdcharacter()).orElse(null);
            if (personajeExistente != null) {
                if (personaje.getName() != null) personajeExistente.setName(personaje.getName());
                if (personaje.getAge() != null) personajeExistente.setAge(personaje.getAge());
                if (personaje.getImage() != null) personajeExistente.setImage(personaje.getImage());
                if (personaje.getStory() != null) personajeExistente.setStory(personaje.getStory());
                if (personaje.getWeight() != null) personajeExistente.setWeight(personaje.getWeight());
                return characterRepository.save(personajeExistente);
            }else personaje.setIdcharacter(null);
        }
        return (personaje.estoyBienFormado())?characterRepository.save(personaje):null;
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

    public Character getCharacterById(Integer id) {
        return characterRepository.getById(id);
    }

    public List<Character> findCharacters(Optional<String> name, Optional<Integer> age, Optional<Integer> movies) {
        try{
            if(movies.isPresent()) {
                Movie movie = movieRepository.findById(movies.get()).orElseThrow(Exception::new);
                if(name.isPresent() && age.isPresent())
                    return characterRepository.findCharactersByNameContainingAndAgeEqualsAndMoviesContaining(name.get(), age.get(), movie);
                else if(name.isPresent())
                    return characterRepository.findCharactersByNameContainingAndMoviesContaining(name.get(), movie);
                else if(age.isPresent())
                    return characterRepository.findCharactersByAgeEqualsAndMoviesContaining(age.get(), movie);
                else
                    return characterRepository.findCharactersByMoviesContaining(movie);
            }else {
                if(name.isPresent() && age.isPresent())
                    return characterRepository.findCharactersByNameContainingAndAgeEquals(name.get(), age.get());
                else if(name.isPresent())
                    return characterRepository.findCharactersByNameContaining(name.get());
                else if(age.isPresent())
                    return characterRepository.findCharactersByAgeEquals(age.get());
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public List<Map<String, String>> listarPersonajes() {
        List<Map<String,String>> lista = new ArrayList<>();
        for(Character personaje : characterRepository.findAll())
            lista.add(Map.of("name", personaje.getName(), "image_url", personaje.getImage()));
        return lista;
    }
}
