package com.Oreki.Lesson_Tracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Oreki.Lesson_Tracker.UserPrincipal;
import com.Oreki.Lesson_Tracker.Models.Users;
import com.Oreki.Lesson_Tracker.Repositories.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UsersRepository usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Users user = usersRepo.findByUsername(username);

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        if(user == null){
            throw new UsernameNotFoundException("Unimplemented method 'loadUserByUsername'");
        }
        return new UserPrincipal(user);
        
    }

}
