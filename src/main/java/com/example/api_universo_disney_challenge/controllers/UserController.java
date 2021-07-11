package com.example.api_universo_disney_challenge.controllers;

import com.example.api_universo_disney_challenge.entities.User;
import com.example.api_universo_disney_challenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public String register(@RequestBody User usuario){
    return userService.crearUsuarioYGuardarlo(usuario);
    }


}
