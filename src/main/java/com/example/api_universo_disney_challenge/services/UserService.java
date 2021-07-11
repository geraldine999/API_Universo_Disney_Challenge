package com.example.api_universo_disney_challenge.services;

import com.example.api_universo_disney_challenge.entities.User;
import com.example.api_universo_disney_challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String crearUsuarioYGuardarlo(User usuario) {
        if(userRepository.existsByName(usuario.getName())){
            return "Usuario existente";
        }else {
            Random random = new Random();
            Integer numeroAleatorio = random.nextInt(999);
            String token = usuario.getName() + numeroAleatorio;
            Integer apiCallsLimit = 1000;
            usuario.setToken(token);
            usuario.setApiCallsAvailable(apiCallsLimit);
            usuario.setApiCallsLimit(apiCallsLimit);
            userRepository.save(usuario);
            return token;
        }
    }
}
