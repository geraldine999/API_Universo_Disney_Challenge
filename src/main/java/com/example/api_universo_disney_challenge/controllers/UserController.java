package com.example.api_universo_disney_challenge.controllers;

import com.example.api_universo_disney_challenge.entities.User;
import com.example.api_universo_disney_challenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public String register(@RequestBody User usuario){
    return userService.crearUsuarioYGuardarlo(usuario);
    }

    @PostMapping("auth/login")
    public String login(@RequestParam String email, @RequestParam String token){
        return userService.login(email, token);
    }

}
