package com.example.api_universo_disney_challenge.controllers;

import com.example.api_universo_disney_challenge.entities.Character;
import com.example.api_universo_disney_challenge.entities.Movie;
import com.example.api_universo_disney_challenge.services.CharacterService;
import com.example.api_universo_disney_challenge.services.MovieService;
import com.example.api_universo_disney_challenge.services.UserService;
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
    private final UserService userService;

    @Autowired
    public CharacterController(CharacterService characterService, MovieService movieService, UserService userService) {
        this.characterService = characterService;
        this.movieService = movieService;
        this.userService = userService;
    }


    private boolean validarYRegistrarApiCall(Optional<String> email, Optional<String> token){
        if(token.isPresent() && email.isPresent()){
            return userService.validateTemporalTokenAndCountApiCall(email.get(), token.get());

        }
        return false;
    }

    //hacer esto en todos los endpoints y en cada controlador PERO NO PORQUE SE USA SPRING SECURITY
    @GetMapping("images") //@RequestParam -> url?token={token}&email={email}
    public List<Map<String, String>> listarPersonajesNombreEImagen(@RequestParam Optional<String> email,
                                                                   @RequestParam Optional <String> token){
        return validarYRegistrarApiCall(email, token)? characterService.listarPersonajes():null;
    }



    @GetMapping("/all")
    public List<Character> listarTodosLosPersonajes(@RequestParam Optional<String> email,
                                                    @RequestParam Optional <String> token){
        return validarYRegistrarApiCall(email, token)? characterService.getAll():null;
    }

    @GetMapping("/{id}")
    private Character getCharacterById(@PathVariable Integer id){
        return characterService.getCharacterById(id);
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


   @GetMapping()
   private List<Character> buscar(@RequestParam Optional<String> name,
                                  @RequestParam Optional<Integer> age,
                                  @RequestParam Optional<Integer> movies){
        return characterService.findCharacters(name, age, movies);
   }

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
