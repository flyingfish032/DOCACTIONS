package com.example.demo.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.jobportalrepo;

@Service
public class UsersManager {

    @Autowired
    jobportalrepo jr;

    @Autowired
    JWTManager JM;

    public String addUser(Users U) {
        if (jr.validateEmail(U.getEmail()) > 0) {
            return "401::User Email already exists.";
        }

        // if frontend didn’t send a role, default to "user"
        if (U.getRole() == null || U.getRole().isBlank()) {
            U.setRole("user");
        }

        jr.save(U);
        return "200::User Added Successfully";
    }

    public String login(String email, String password) {
        if (jr.validateCredentials(email, password) > 0) {

            // generate token as before
            String token = JM.generateToken(email);

            // fetch user to read role
            Optional<Users> opt = jr.findById(email);
            String role = "user";
            if (opt.isPresent() && opt.get().getRole() != null && !opt.get().getRole().isBlank()) {
                role = opt.get().getRole();
            }

            // IMPORTANT: frontend expects "code::token::role"
            return "200::" + token + "::" + role;
        }

        return "401::Invalid Credentials";
    }

    public String getUsername(String token) {
        String email = JM.validateToken(token);
        if (email.compareTo("401") == 0) {
            return "401::Token Expired";
        }
        Users U = jr.findById(email).get();
        return U.getUsername();
    }
}
