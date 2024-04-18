package com.example.quora.controller;

import com.example.quora.models.User;
import com.example.quora.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    UserServices userServices;
    public UserController(UserServices userServices){
        this.userServices=userServices;
    }

    @PostMapping("/")
    public ResponseEntity<User> RegisterUser(@RequestBody User user){
        User res=userServices.createUser(user);
        return new ResponseEntity<> (res,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetails(@PathVariable Long id){
        User res = userServices.getUser(id);
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserDetails(@RequestBody User user, @PathVariable Long id){
       User res = userServices.updateUser(user, id);
       return ResponseEntity.ok(res);
    }
}
