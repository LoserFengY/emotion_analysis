package com.neusoft.emotion_analysis.service;

import com.neusoft.emotion_analysis.entity.User;
import com.neusoft.emotion_analysis.util.Result;

public interface LoginService {

    Result login(User user);

    Result logout();
}