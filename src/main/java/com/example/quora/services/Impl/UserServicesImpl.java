package com.example.quora.services.Impl;

import com.example.quora.exceptionhandeler.ResourceDuplicateException;
import com.example.quora.exceptionhandeler.ResourceNotFoundException;
import com.example.quora.models.User;
import com.example.quora.repository.UserRepo;
import com.example.quora.services.UserServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepo userRepo;

    public UserServicesImpl(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public User createUser(User user) {
        String userName = user.getEmail();
        Optional<User> byUserName = userRepo.findByEmail(userName);

        if(byUserName.isPresent()) throw new ResourceDuplicateException(userName);
        return userRepo.save(user);
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
    public User getUser(Long id) {
        return userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
