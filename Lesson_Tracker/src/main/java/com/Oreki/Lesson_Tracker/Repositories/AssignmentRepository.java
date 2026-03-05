package com.Oreki.Lesson_Tracker.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Oreki.Lesson_Tracker.Models.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    
}
