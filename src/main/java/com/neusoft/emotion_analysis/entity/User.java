package com.neusoft.emotion_analysis.entity;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userInformation;
}
