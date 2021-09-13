package com.example.api_universo_disney_challenge.repositories;

import com.example.api_universo_disney_challenge.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByName(String name);

    User findUserByEmailAndToken(String email, String token);

    boolean existsByEmailAndTokenTemporal(String email, String tokenTemporal);

    User findUserByEmailAndTokenTemporal(String email, String tokenTemporal);

    User findUserByEmail(String email);
}
