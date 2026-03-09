package com.Oreki.Lesson_Tracker.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Oreki.Lesson_Tracker.Models.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    
    List<Assignment> findByUserID(int userID);
}
