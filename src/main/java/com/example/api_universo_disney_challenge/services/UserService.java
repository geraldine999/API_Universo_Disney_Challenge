package com.example.api_universo_disney_challenge.services;

import com.example.api_universo_disney_challenge.entities.User;
import com.example.api_universo_disney_challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);

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
            String resultadoToken = encoder.encode(usuario.getName()+numeroAleatorio);
            Integer apiCallsLimit = 1000;
            usuario.setToken(resultadoToken);
            usuario.setApiCallsAvailable(apiCallsLimit);
            usuario.setApiCallsLimit(apiCallsLimit);
            userRepository.save(usuario);
            return usuario.getName()+numeroAleatorio;
        }
    }

    public String login(String email, String token) { //token temporal = id de sesión
        User user = userRepository.findUserByEmail(email);
        if(user != null && encoder.matches(token, user.getToken())){
            user.setTokenTemporal(String.valueOf(Math.round((Math.random()*100000)+1)));
            userRepository.save(user);
            return user.getTokenTemporal();
        }
        return "Error de acceso";
    }

    public boolean validateTemporalTokenAndCountApiCall(String email, String tokenTemporal) {
        User user =  userRepository.findUserByEmailAndTokenTemporal(email, tokenTemporal);
        if(user !=null && user.getApiCallsAvailable() > 0){
            user.consumirApiCall();
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
