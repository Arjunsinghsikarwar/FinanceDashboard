package com.example.FinanceDataProcessing.FinanceProject.Controller;

import com.example.FinanceDataProcessing.FinanceProject.DTOs.LoginInfoDTOs;
import com.example.FinanceDataProcessing.FinanceProject.ExceptionHandling.UserAlreadyExistException;
import com.example.FinanceDataProcessing.FinanceProject.JWT.JWTService;
import com.example.FinanceDataProcessing.FinanceProject.Model.User;
import com.example.FinanceDataProcessing.FinanceProject.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService service;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody LoginInfoDTOs loginInfo)
    {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginInfo.getUserName(), loginInfo.getPassword()));
        }
            catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid username or password"));
        }
        User user =  userRepo.findByUserName(loginInfo.getUserName());
        if (!user.getStatus().equalsIgnoreCase("ACTIVE")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "User is inactive"));
        }
       String token = service.generateToken(user);
       return new ResponseEntity<>(Map.of("token",token,"userName",loginInfo.getUserName(),"role",user.getRole()), HttpStatus.OK);
    }

}
