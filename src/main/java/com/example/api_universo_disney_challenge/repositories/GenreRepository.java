package com.example.api_universo_disney_challenge.repositories;

import com.example.api_universo_disney_challenge.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
