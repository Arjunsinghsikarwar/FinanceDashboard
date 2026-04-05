package com.example.FinanceDataProcessing.FinanceProject.DTOs;

public class RoleUpdateDTOs {
    private String userId;
    private String role;

    public RoleUpdateDTOs() {
    }

    public RoleUpdateDTOs(String role, String userId) {
        this.role = role;
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
