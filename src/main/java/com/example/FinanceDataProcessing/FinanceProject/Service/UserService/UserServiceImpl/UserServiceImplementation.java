package com.example.FinanceDataProcessing.FinanceProject.Service.UserService.UserServiceImpl;

import com.example.FinanceDataProcessing.FinanceProject.Enums.Role;
import com.example.FinanceDataProcessing.FinanceProject.ExceptionHandling.ResourceNotFound;
import com.example.FinanceDataProcessing.FinanceProject.ExceptionHandling.UserAlreadyExistException;
import com.example.FinanceDataProcessing.FinanceProject.Model.User;
import com.example.FinanceDataProcessing.FinanceProject.Repo.UserRepo;
import com.example.FinanceDataProcessing.FinanceProject.Service.UserService.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserServiceInterface {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createNewUser(User user) {
      User user1 = userRepo.findByUserName(user.getUserName());
      if(user1==null)
      {
        String userId = UUID.randomUUID().toString();
        user.setRole(Role.VIEWER);
        user.setStatus("ACTIVE");
        user.setUserId(userId);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepo.save(user);
      }
      else {
          throw new UserAlreadyExistException("This UserName Already Exist");
      }

    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String userId) {
      return userRepo.findById(userId).orElseThrow(()-> new ResourceNotFound("This userId user do not exist"+userId));
    }

    @Override
    public User updateUser(String userId, User user) {
        User user1 = getUserById(userId);
        user1.setUserName(user.getUserName());
        user1.setEmail(user.getEmail());
        user1.setStatus(user.getStatus());
       return userRepo.save(user1);
    }

    @Override
    public User deleteuser(String userId) {
       User user = getUserById(userId);
        userRepo.delete(user);
        return user;
    }

    @Override
    public User updateRole(String role, String userId) {
        User user = getUserById(userId);
        Role role1;
        try{
            role1 = Role.valueOf(role.toUpperCase());
        }
        catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role :" + role);
        }
        user.setRole(role1);
        return userRepo.save(user);
    }
}
