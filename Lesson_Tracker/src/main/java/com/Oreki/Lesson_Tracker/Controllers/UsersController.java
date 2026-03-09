package com.Oreki.Lesson_Tracker.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki.Lesson_Tracker.Models.Users;
import com.Oreki.Lesson_Tracker.Service.UsersService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/getAll")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    // Made the return statement a switch statement to easily add any new case for
    // response later
    @PostMapping("/save")
    public ResponseEntity<String> saveUsers(@RequestBody Users user) {
        String response = usersService.saveUser(user);
        return switch (response) {
            case "OK" -> new ResponseEntity<>("User Updated Successfully", HttpStatus.OK);
            case "Duplicate" -> new ResponseEntity<>("Duplicate Reccord", HttpStatus.CONFLICT);
            default -> new ResponseEntity<>("Somthing Failed", HttpStatus.BAD_REQUEST);
        };
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUsers(@RequestBody Users user) {
        String response = usersService.updateUser(user);
        return switch (response) {
            case "OK" -> new ResponseEntity<>("User Updated Successfully", HttpStatus.OK);
            default -> new ResponseEntity<>("Somthing Failed", HttpStatus.BAD_REQUEST);
        };
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");

    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestBody Users user) {

        if (usersService.verifyUser(user)) {
            return new ResponseEntity<>("Login Verified", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Somthing Failed", HttpStatus.BAD_REQUEST);
        }

    }

}
