package com.example.api_universo_disney_challenge.entities;

import lombok.Data;

import javax.persistence.*;

@Data //A shortcut for @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String name;
    private String email;
    private String token; //nombre+numero aleatorio (pablo123)
    private String tokenTemporal;
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

    //ESTO DEBERIA IR EN OTRA CLASE
    public void consumirApiCall() {
        this.apiCallsAvailable--;
    }
}
