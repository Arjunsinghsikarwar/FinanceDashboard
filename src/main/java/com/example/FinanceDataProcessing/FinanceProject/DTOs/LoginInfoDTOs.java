package com.example.FinanceDataProcessing.FinanceProject.DTOs;

public class LoginInfoDTOs {
    private String userName;
    private String password;

    public LoginInfoDTOs() {
    }

    public LoginInfoDTOs(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
