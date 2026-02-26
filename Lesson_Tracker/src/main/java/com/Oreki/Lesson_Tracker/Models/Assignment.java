package com.Oreki.Lesson_Tracker.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // dropbox
    @Column(name = "userID")
    private int userID;

    // dropbox
    @Column(name = "exeID")
    private int exeID;

    // radio
    @Column(name = "status")
    private String status;

    // text area
    @Column(name = "feedback")
    private String feedback;

    // texxt
    @Column(name = "audioURL")
    private String audioURL;

    // get and set below

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public int getExeID() {
        return exeID;
    }

    public String getStatus() {
        return status;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setExeID(int exeID) {
        this.exeID = exeID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

}

