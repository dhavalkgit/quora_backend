package com.example.quora.controller;

import com.example.quora.dtos.UserResponseDto;
import com.example.quora.helper.UserHelper;
import com.example.quora.models.User;
import com.example.quora.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserServices userServices;
    private final UserHelper userHelper;

    public UserController(UserServices userServices, UserHelper userHelper){
        this.userHelper=userHelper;
        this.userServices=userServices;
    }

    @PostMapping("/")
    public ResponseEntity<UserResponseDto> RegisterUser(@RequestBody User user){
        User res=userServices.createUser(user);
        UserResponseDto userResponse = userHelper.sendUserResponse(res);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetails(@PathVariable Long id){
        User res = userServices.getUser(id);
        UserResponseDto userResponse = userHelper.sendUserResponse(res);
        return new ResponseEntity<>(userResponse, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserDetails(@RequestBody User user, @PathVariable Long id){
       User res = userServices.updateUser(user, id);
        UserResponseDto userResponse = userHelper.sendUserResponse(res);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
