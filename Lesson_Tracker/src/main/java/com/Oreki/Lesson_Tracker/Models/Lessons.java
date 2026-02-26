package com.Oreki.Lesson_Tracker.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lessons {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column
    public String title;

    @Column
    public String lessonURL;

    

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLessonURL() {
        return lessonURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExeURL(String lessonURL) {
        this.lessonURL = lessonURL;
    }

    


    
    
}
