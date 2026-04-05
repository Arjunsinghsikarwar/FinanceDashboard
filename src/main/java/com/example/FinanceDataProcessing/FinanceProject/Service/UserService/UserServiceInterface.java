package com.example.FinanceDataProcessing.FinanceProject.Service.UserService;

import com.example.FinanceDataProcessing.FinanceProject.Model.User;

import java.util.List;

public interface UserServiceInterface {
    User createNewUser(User user);

    List<User> getAllUser();

    User getUserById(String userId);

    User updateUser(String userId , User user);

    User deleteuser(String userId);

    User updateRole(String role , String userId);
}
