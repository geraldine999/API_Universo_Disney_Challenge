package com.example.api_universo_disney_challenge.services;

import com.example.api_universo_disney_challenge.entities.Movie;
import com.example.api_universo_disney_challenge.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;


    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }



    public Movie findById(Integer idmovie) {
        return movieRepository.findById(idmovie).orElse(null);
    }
}
