package com.example.FinanceDataProcessing.FinanceProject.Controller;

import com.example.FinanceDataProcessing.FinanceProject.DTOs.RoleUpdateDTOs;
import com.example.FinanceDataProcessing.FinanceProject.Model.User;
import com.example.FinanceDataProcessing.FinanceProject.Service.UserService.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceInterface userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<Map<String,List<User>>> getAllUser()
    {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Users",allUser));
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId)
    {
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Map<String , Object>> deleteUser(@PathVariable String userId)
    {
        User user = userService.deleteuser(userId);
        return ResponseEntity.status(200).body(Map.of("status","Successfully Delete","user",user));
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId,@RequestBody User user)
    {
        User user1 = userService.updateUser(userId,user);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    @PutMapping("/updateRole")
    public ResponseEntity<Map<String,Object>> updateRole(@RequestBody RoleUpdateDTOs updateDTOs) {
        User user = userService.updateRole(updateDTOs.getRole(), updateDTOs.getUserId());
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("status", "Role Updated Successfully", "user", user));
    }
}
