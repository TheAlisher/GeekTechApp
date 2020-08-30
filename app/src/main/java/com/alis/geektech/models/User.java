package com.alis.geektech.models;

import java.io.Serializable;

public class User implements Serializable {

    private String userPhoto;
    private String userName;
    private String userLevel;
    private String userGitHub;
    private String userPassword;
    private String isTopMentor;

    public User(String userPhoto, String userName, String userLevel, String userGitHub) {
        this.userPhoto = userPhoto;
        this.userName = userName;
        this.userLevel = userLevel;
        this.userGitHub = userGitHub;
    }

    public User(String userPhoto, String userName, String userLevel, String userGitHub, String userPassword, String isTopMentor) {
        this.userPhoto = userPhoto;
        this.userName = userName;
        this.userLevel = userLevel;
        this.userGitHub = userGitHub;
        this.userPassword = userPassword;
        this.isTopMentor = isTopMentor;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserGitHub() {
        return userGitHub;
    }

    public void setUserGitHub(String userGitHub) {
        this.userGitHub = userGitHub;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getIsTopMentor() {
        return isTopMentor;
    }

    public void setIsTopMentor(String isTopMentor) {
        this.isTopMentor = isTopMentor;
    }
}
