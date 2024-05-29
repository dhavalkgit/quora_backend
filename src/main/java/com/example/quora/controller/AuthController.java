package com.example.quora.controller;

import com.example.quora.dtos.UserResponseDto;
import com.example.quora.dtos.UserSignInDto;
import com.example.quora.dtos.UserSignUpDto;
import com.example.quora.helper.UserHelper;
import com.example.quora.models.User;
import com.example.quora.services.Impl.JwtService;
import com.example.quora.services.UserServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private  final UserServices userServices;
    private final UserHelper userHelper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController (UserServices userServices, UserHelper userHelper,
                           AuthenticationManager authenticationManager,
                           JwtService jwtService){
        this.userServices=userServices;
        this.userHelper=userHelper;
        this.authenticationManager=authenticationManager;
        this.jwtService=jwtService;
    }

    @PostMapping("/signup/users")
    public ResponseEntity<?> userSignUp(@RequestBody UserSignUpDto userSignUpDto){
        User res=userServices.createUser(userSignUpDto);
        UserResponseDto userResponse = userHelper.sendUserResponse(res);
        if(res==null)
            return new ResponseEntity<>(Map.of("message", "User is all ready present"),
                                        HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("signin/users")
    public ResponseEntity<?> userSignIn(@RequestBody UserSignInDto userSignInDto, HttpServletResponse response){
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userSignInDto.getEmail(), userSignInDto.getPassword()));

        if(authenticate.isAuthenticated()){
            try {
                User user = userServices.getByUserName(userSignInDto.getEmail());
                String token = jwtService.generateToken(user);
                ResponseCookie cookie = ResponseCookie.from("JwtToken", token)
                        .httpOnly(true)
                        .path("/")
                        .secure(false)
                        .maxAge(7 * 3600L)
                        .build();
                response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
                return ResponseEntity.ok("success");
            }
            catch (Exception e){
                throw new RuntimeException();
            }
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Failed");
    }
}
