package com.iesvdc.demo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iesvdc.demo.Models.User;
import com.iesvdc.demo.Repos.RepoUser;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/users")
public class ControUser {
    private final RepoUser repoUser;

    public ControUser(RepoUser repoUser) {
        this.repoUser = repoUser;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repoUser.findAll();
    }
}
