package com.Oreki.Lesson_Tracker.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki.Lesson_Tracker.Models.Users;
import com.Oreki.Lesson_Tracker.Service.UsersService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/verify")
    public String verifyUser(@RequestBody Users user) {

        if (!usersService.verifyUser(user).isEmpty()) {
            return usersService.verifyUser(user);
        } else {
            return "Failed";
        }

    }

    // Made the return statement a switch statement to easily add any new case for
    // response later
    @PostMapping("/register")
    public ResponseEntity<String> saveUsers(@RequestBody Users user) {
        String response = usersService.saveUser(user);
        return switch (response) {
            case "OK" -> new ResponseEntity<>("User added Successfully", HttpStatus.OK);
            case "Duplicate" -> new ResponseEntity<>("Duplicate Reccord", HttpStatus.CONFLICT);
            default -> new ResponseEntity<>("Somthing Failed", HttpStatus.BAD_REQUEST);
        };
    }

}
