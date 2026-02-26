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

import com.Oreki.Lesson_Tracker.Models.Users;
import com.Oreki.Lesson_Tracker.UsersService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/getAll")
    public List<Users> getAllStudents(){
        return usersService.getAllStudents();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUsers(@RequestBody Users user){
        String response = usersService.saveUser(user);
        if(response.equals("OK")){
            return new ResponseEntity<>("User added successfull",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Somthing Failed",HttpStatus.BAD_REQUEST);
        }
    }
    
}
