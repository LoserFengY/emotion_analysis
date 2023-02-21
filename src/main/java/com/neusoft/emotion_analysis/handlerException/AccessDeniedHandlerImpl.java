package com.neusoft.emotion_analysis.handlerException;


import com.alibaba.fastjson.JSON;
import com.neusoft.emotion_analysis.util.Result;
import com.neusoft.emotion_analysis.util.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        WebUtils.renderString(response, JSON.toJSONString(Result.error("授权失败")));
    }

}
