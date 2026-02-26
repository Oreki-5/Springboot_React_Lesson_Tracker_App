package com.Oreki.Lesson_Tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.Oreki.Lesson_Tracker.Models.Users;
import com.Oreki.Lesson_Tracker.Repositories.UsersRepository;


@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;


    public List<Users> getAllStudents(){
        List<Users> users = new ArrayList<>();
        Streamable.of(usersRepository.findAll()).forEach(users::add);
        return users;
    }

    public String saveUser(Users user){
        usersRepository.saveAndFlush(user);
        
        return "OK";
    }

}
