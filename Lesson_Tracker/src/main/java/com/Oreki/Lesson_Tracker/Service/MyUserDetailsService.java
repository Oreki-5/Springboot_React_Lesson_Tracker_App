package com.Oreki.Lesson_Tracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Oreki.Lesson_Tracker.Models.Users;
import com.Oreki.Lesson_Tracker.Repositories.UsersRepository;
import com.Oreki.Lesson_Tracker.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UsersRepository usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Users user = usersRepo.findByUsername(username);

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        return new UserPrincipal(user);
        
    }

}
