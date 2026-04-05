package com.example.FinanceDataProcessing.FinanceProject.Controller;

import com.example.FinanceDataProcessing.FinanceProject.Model.User;
import com.example.FinanceDataProcessing.FinanceProject.Service.UserService.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Autowired
    private UserServiceInterface service;

    @PostMapping("/signUp")
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        return new ResponseEntity<>(service.createNewUser(user), HttpStatus.OK);
    }

}
