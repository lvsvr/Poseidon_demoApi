package com.poseidon.api.demo.domain;


import com.poseidon.api.demo.config.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    @NotBlank(message = "Username is mandatory")
    private String username;
    @ValidPassword
    @Column(name = "password")
    @NotBlank(message = "Password is mandatory")
    private String password;
    @Column(name = "fullname")
    @NotBlank(message = "FullName is mandatory")
    private String fullName;
    @Column(name = "role")
    @NotBlank(message = "Role is mandatory")
    private String role;

    public User() {
    }

    public User(String username, String password, String fullName, String role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
