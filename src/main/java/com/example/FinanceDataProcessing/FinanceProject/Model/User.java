package com.example.FinanceDataProcessing.FinanceProject.Model;

import com.example.FinanceDataProcessing.FinanceProject.Enums.Role;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    private String userId;
    @Column(unique = true)
    private String userName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String status;
    private String password;


    public User() {
    }

    public User(String email, Role role, String status, String userId, String userName,String password) {
        this.email = email;
        this.role = role;
        this.status = status;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
