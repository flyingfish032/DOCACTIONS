package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Column(name = "username")
    String username;

    @Id
    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "role")
    String role;     // <-- NEW FIELD

    public String getUsername() {
        return username;
    }

    public void setUsername(String fullname) {
        this.username = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // --- NEW GETTER / SETTER ---
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users [username=" + username +
               ", email=" + email +
               ", password=" + password +
               ", role=" + role + "]";
    }
}
