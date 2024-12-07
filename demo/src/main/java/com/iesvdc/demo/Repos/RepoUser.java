package com.iesvdc.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iesvdc.demo.Models.User;

public interface RepoUser extends JpaRepository<User, Long> {
    
}