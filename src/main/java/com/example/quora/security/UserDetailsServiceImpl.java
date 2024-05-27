package com.example.quora.security;

import com.example.quora.models.User;
import com.example.quora.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepo.findByEmail(username);
        if(byEmail.isPresent())
            return new UserDetailsImpl(byEmail.get());
        else
            throw new UsernameNotFoundException("user is not present with given username: "+ username);
    }
}
