package com.neusoft.emotion_analysis.handlerException;

import com.alibaba.fastjson.JSON;
import com.neusoft.emotion_analysis.util.Result;
import com.neusoft.emotion_analysis.util.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
//认证失败
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        //异常处理
        WebUtils.renderString(response, JSON.toJSONString(Result.error("认证失败")));
    }
}
