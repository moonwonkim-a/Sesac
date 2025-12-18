package com.ohgiraffers.jwtsecurity.auth.model.dto;

public class LoginDTO {

    private String userId;
    private String userPass;

    public LoginDTO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "userId='" + userId + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
