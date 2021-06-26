package com.example.api_universo_disney_challenge.controllers;

import com.example.api_universo_disney_challenge.entities.Character;
import com.example.api_universo_disney_challenge.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("characters")
public class DisneyController {

    private final CharacterService characterService;

    @Autowired
    public DisneyController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping()
    public List<Character> findAll(){
        return characterService.findAll();
    }
}
