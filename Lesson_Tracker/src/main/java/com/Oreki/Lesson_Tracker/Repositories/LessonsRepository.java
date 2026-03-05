package com.Oreki.Lesson_Tracker.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Oreki.Lesson_Tracker.Models.Lessons;

public interface LessonsRepository extends JpaRepository<Lessons, Integer>{

}
