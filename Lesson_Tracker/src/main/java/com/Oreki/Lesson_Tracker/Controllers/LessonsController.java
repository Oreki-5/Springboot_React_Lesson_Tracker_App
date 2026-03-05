package com.Oreki.Lesson_Tracker.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki.Lesson_Tracker.Models.Lessons;
import com.Oreki.Lesson_Tracker.Service.UsersService;

@CrossOrigin
@RestController
@RequestMapping("/lessons")
public class LessonsController {
    @Autowired
    UsersService usersService;

    @GetMapping("/getAll")
    public List<Lessons> getAllLessons() {
        return usersService.getAllLessons();
    }

    // Made the return statement a switch statement to easily add any new case for response later
    @PostMapping("/save")
    public ResponseEntity<String> saveLessons(@RequestBody Lessons lessons) {
        String response = usersService.saveLesson(lessons);
        return switch (response) {
            case "OK" -> new ResponseEntity<>("Lesson Added Successfully", HttpStatus.OK);
            case "Duplicate" -> new ResponseEntity<>("Duplicate Reccord", HttpStatus.CONFLICT);
            default -> new ResponseEntity<>("Somthing Failed", HttpStatus.BAD_REQUEST);
        };
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateLesson(@RequestBody Lessons lesson) {
        String response = usersService.updateLesson(lesson);
        return switch (response) {
            case "OK" -> new ResponseEntity<>("Lesson Updated Successfully", HttpStatus.OK);
            default -> new ResponseEntity<>("Somthing Failed", HttpStatus.BAD_REQUEST);
        };
    }

}
