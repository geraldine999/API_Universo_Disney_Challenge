package com.example.api_universo_disney_challenge.entities;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer user_id;
    private String name;
    private String email;
    private String token; //nombre+numero aleatorio (pablo123)
    private String justification;
    private Integer apiCallsLimit; //1000
    private Integer apiCallsAvailable; //200

    public User() {
    }

    public User(String name, String email, String justification) {
        this.name = name;
        this.email = email;
        this.justification = justification;
    }

    public User(Integer user_id, String name, String email, String token, String justification, Integer apiCallsLimit, Integer apiCallsAvailable) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.token = token;
        this.justification = justification;
        this.apiCallsLimit = apiCallsLimit;
        this.apiCallsAvailable = apiCallsAvailable;
    }

    public User(String name, String email, String token, String justification, Integer apiCallsLimit, Integer apiCallsAvailable) {
        this.name = name;
        this.email = email;
        this.token = token;
        this.justification = justification;
        this.apiCallsLimit = apiCallsLimit;
        this.apiCallsAvailable = apiCallsAvailable;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String use) {
        this.justification = use;
    }

    public Integer getApiCallsLimit() {
        return apiCallsLimit;
    }

    public void setApiCallsLimit(Integer apiCallsLimit) {
        this.apiCallsLimit = apiCallsLimit;
    }

    public Integer getApiCallsAvailable() {
        return apiCallsAvailable;
    }

    public void setApiCallsAvailable(Integer apiCallsAvailable) {
        this.apiCallsAvailable = apiCallsAvailable;
    }
}
