package com.Oreki.Lesson_Tracker.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Oreki.Lesson_Tracker.Models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

    Users findByUsername(String username);
    
}
    
