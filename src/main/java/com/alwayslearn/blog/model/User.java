package com.alwayslearn.blog.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String userId;
    private String password;
    private String email;
    private String phone;
    private String name;

    public User(long id, String userId, String password, String email, String phone, String name){
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    
}
