package com.example.quora.services.Impl;

import com.example.quora.dtos.UserSignUpDto;
import com.example.quora.exceptionhandeler.ResourceNotFoundException;
import com.example.quora.models.User;
import com.example.quora.repository.UserRepo;
import com.example.quora.services.UserServices;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServicesImpl(UserRepo userRepo, PasswordEncoder passwordEncoder){
        this.userRepo=userRepo;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public User createUser(UserSignUpDto user) {
        User dbUser=User.builder()
                .email(user.getEmail())
                .about(user.getAbout())
                .name(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .build();
       return userRepo.save(dbUser);
    }

    @Override
    public User updateUser(User newUserData, Long id) {
        Optional<User> oldUserData = userRepo.findById(id);
        if(oldUserData.isPresent()) {
            oldUserData.get().setAbout(newUserData.getAbout());
            oldUserData.get().setName(newUserData.getName());
            oldUserData.get().setEmail(newUserData.getEmail());
        }
        return userRepo.save(oldUserData.get());
    }

    @Override
    public User getByUserName(String username) {
        Optional<User> byEmail = userRepo.findByEmail(username);
        return byEmail.orElse(null);
    }

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public boolean addFollow(Long userId, Long targetUserId) {
        Optional<User> userFollowers = userRepo.findById(targetUserId);
        Optional<User> userFollowing = userRepo.findById(userId);

        userFollowing.get().addFollowing(userFollowers.get());
        userFollowers.get().addFollowers(userFollowing.get());

         userRepo.save(userFollowing.get());
         userRepo.save(userFollowers.get());

        return true;
    }
}
