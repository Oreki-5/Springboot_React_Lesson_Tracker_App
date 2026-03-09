package com.Oreki.Lesson_Tracker.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Oreki.Lesson_Tracker.Models.Assignment;
import com.Oreki.Lesson_Tracker.Models.Lessons;
import com.Oreki.Lesson_Tracker.Models.Users;
import com.Oreki.Lesson_Tracker.Repositories.AssignmentRepository;
import com.Oreki.Lesson_Tracker.Repositories.LessonsRepository;
import com.Oreki.Lesson_Tracker.Repositories.UsersRepository;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private LessonsRepository lessonsRepository;

    @Autowired
    public AuthenticationManager authManager;

    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        Streamable.of(usersRepository.findAll()).forEach(users::add);
        return users;
    }

    public List<Users> getUsersByName(String name) {
        List<Users> users = new ArrayList<>();
        Streamable.of(usersRepository.findAll()).filter(record -> record.getUsername().equals(name))
                .forEach(users::add);
        return users;
    }

    public boolean getUsersByNameAndPassword(String name, String password) {
        List<Users> users = new ArrayList<>();
        Streamable.of(usersRepository.findAll())
                .filter(record -> record.getUsername().equals(name) && record.getPassword().equals(password))
                .forEach(users::add);
        return !users.isEmpty();
    }

    public String saveUser(Users user) {

        List<Users> existing = getUsersByName(user.getUsername());
        if (!existing.isEmpty()) {
            return "Duplicate";
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            user.setPassword(encoder.encode(user.getPassword()));
            usersRepository.saveAndFlush(user);
            return "OK";
        }

    }

    public boolean deleteStudent(int id) {

        // Checking if the lessons id exist in assignment table
        List<Assignment> assignment = new ArrayList<>();
        Streamable.of(assignmentRepository.findAll()).filter(record -> record.getUserID() == id)
                .forEach(assignment::add);
        usersRepository.deleteById(id);
        if (!assignment.isEmpty()) {
            assignment.forEach(record -> assignmentRepository.delete(record));
            return true;
        } else {
            return false;
        }

    }

    public void deleteUser(int id) {
        usersRepository.deleteById(id);
        usersRepository.flush();
    }

    public String updateUser(Users user) {
        usersRepository.saveAndFlush(user);
        return "OK";
    }

    public boolean verifyUser(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        return authentication.isAuthenticated();
    }

    // For Lessons table
    // ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Lessons> getAllLessons() {
        List<Lessons> lessons = new ArrayList<>();
        Streamable.of(lessonsRepository.findAll()).forEach(lessons::add);
        return lessons;
    }

    public List<Lessons> getAllLessonsById(int id) {
        List<Lessons> lessons = new ArrayList<>();
        Streamable.of(lessonsRepository.findAll()).filter(record -> record.getId() == id).forEach(lessons::add);
        return lessons;
    }

    public String saveLesson(Lessons lessons) {
        List<Lessons> dupes = new ArrayList<>();
        Streamable.of(lessonsRepository.findAll()).filter(record -> record.getTitle().equals(lessons.getTitle()))
                .forEach(dupes::add);

        if (dupes.isEmpty()) {

            lessonsRepository.save(lessons);
            return "OK";
        } else {
            return "Duplicate";
        }

    }

    public boolean deleteLesson(int id) {

        // Checking if the lessons id exist in assignment table
        List<Assignment> assignment = new ArrayList<>();
        Streamable.of(assignmentRepository.findAll()).filter(record -> record.getExeID() == id)
                .forEach(assignment::add);
        if (assignment.isEmpty()) {
            lessonsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    public String updateLesson(Lessons lessons) {
        lessonsRepository.save(lessons);
        return "OK";

    }

    // For Assignment table

    public List<Assignment> getAllAssignments() {
        List<Assignment> trackers = new ArrayList<>();
        Streamable.of(assignmentRepository.findAll()).forEach(trackers::add);
        return trackers;
    }

    public List<Assignment> getAssignmentsByUser(int userID) {
        List<Assignment> trackers = assignmentRepository.findByUserID(userID);
        return trackers;
    }

    public List<Assignment> getAssignmentByUserID(int userID) {
        List<Assignment> assignment = new ArrayList<>();
        Streamable.of(assignmentRepository.findAll()).filter(record -> record.getUserID() == userID)
                .forEach(assignment::add);
        return assignment;
    }

    public String saveAssignment(Assignment assignment) {
        List<Assignment> dupes = new ArrayList<>();
        Streamable.of(assignmentRepository.findAll()).filter(
                record -> record.getUserID() == (assignment.getUserID()) && record.getExeID() == assignment.getExeID())
                .forEach(dupes::add);

        if (dupes.isEmpty()) {

            assignmentRepository.save(assignment);
            return "OK";
        } else {
            return "Error";
        }

    }

    public void deleteAssignment(int id) {
        assignmentRepository.deleteById(id);

    }

    public String updateAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
        return "OK";

    }

}
