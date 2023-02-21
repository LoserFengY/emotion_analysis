package com.neusoft.emotion_analysis.filter;

import com.neusoft.emotion_analysis.entity.LoginUser;
import com.neusoft.emotion_analysis.util.BizException;
import com.neusoft.emotion_analysis.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAythenticationTokenFiter extends OncePerRequestFilter {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token

        String token=request.getHeader("token");
        if(token==null||token=="")
        {
            filterChain.doFilter(request,response);
            return ;
        }

        //解析token
        String t = JwtUtils.decodeJwt(token);

        //从redis获取信息
        LoginUser user = (LoginUser)redisTemplate.opsForValue().get(t);
        if(Objects.isNull(user))
        {
            throw new BizException("用户未登录");
        }
        //存入securityContextHolder
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities()));
        filterChain.doFilter(request,response);
    }
}
