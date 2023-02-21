package com.neusoft.emotion_analysis.service.impl;

import com.neusoft.emotion_analysis.entity.LoginUser;
import com.neusoft.emotion_analysis.entity.User;
import com.neusoft.emotion_analysis.service.LoginService;
import com.neusoft.emotion_analysis.util.JwtUtils;
import com.neusoft.emotion_analysis.util.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    private RedisTemplate redisTemplate;
    public Result login(User user)
    {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(user.getUserName(),user.getUserPassword());
        //返回得到Authentication 对象
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if(Objects.isNull(authenticate))
        {
            throw new RuntimeException("用户名或密码错误!");
        }
        LoginUser loginUser= (LoginUser) authenticate.getPrincipal();
        User u=loginUser.getUser();
        String token= JwtUtils.create(u);
        Map<String,Object> map=new HashMap<>();
        map.put("token",token);
        map.put("user", u);
        redisTemplate.opsForValue().set(u.getUserId()+"", loginUser);
        return Result.success(map);
    }

    public Result logout() {
        //通过SecurityContextHolder.getContext()获取对象
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        redisTemplate.delete(loginUser.getUser().getUserId()+"");
        return Result.success("logout");
    }
}
