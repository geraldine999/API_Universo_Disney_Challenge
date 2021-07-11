package com.example.api_universo_disney_challenge.controllers;

import com.example.api_universo_disney_challenge.entities.Character;
import com.example.api_universo_disney_challenge.entities.Movie;
import com.example.api_universo_disney_challenge.services.CharacterService;
import com.example.api_universo_disney_challenge.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;
    private final MovieService movieService;

    @Autowired
    public CharacterController(CharacterService characterService, MovieService movieService) {
        this.characterService = characterService;
        this.movieService = movieService;
    }

    @GetMapping()
    public Map<String, String> listarPersonajesNombreEImagen(){
        return characterService.findAll();
    }//TODO esto deberia retornar una lista de maps

    @GetMapping("prueba")//TODO borrar este metodo??
    public List<Character> listarPersonajes(){
        return characterService.getAll();
    }


    //TODO SAVE, UPDATE

    @PostMapping(path="/save")
    public void guardarPersonaje(@RequestBody Character personaje){
        characterService.save(personaje);
    }//TODO solo actualizar los campos NOT NULL? //esto se rompio y no se por que
    //TODO agregar pelis para cada personaje



    @DeleteMapping("/delete/{id}")
    public void eliminarPersonaje(@PathVariable Integer id){
        characterService.deleteById(id);
    }

    @PostMapping("/update/{id}")
    public void actualizarPersonaje(@PathVariable Integer id){
        Character personaje = characterService.findById(id);
        guardarPersonaje(personaje);
    }

    //TODO busqueda por nombre, peso, edad, idMovie

    @GetMapping("nombre/{name}")
    public Optional<Character> buscarPorNombre(@PathVariable String name){
        return characterService.getCharacterByName(name);//TODO hacerlo containing
    }

    @GetMapping("peso/{weight}")
    public Optional<List<Character>> buscarPorPeso(@PathVariable Double weight){
        return characterService.getCharactersByWeight(weight);
    }

    @GetMapping("idPelicula/{idmovie}") //TODO probar esto, BIEN, como agrego mas personajes en una peli?
    public List<Character> buscarPersonajesPorIdPelicula(@PathVariable Integer idmovie){
        Movie movie = movieService.findById(idmovie);
        if(movie != null){
            List<Character> listaDePersonajes = movie.getCharacters();
            return listaDePersonajes;
        }else{
            return null;
        }
    }


}
