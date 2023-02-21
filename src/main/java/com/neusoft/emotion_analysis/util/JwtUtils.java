package com.neusoft.emotion_analysis.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.neusoft.emotion_analysis.entity.User;

public class JwtUtils {

    public static  String create(User user)
    {
        String token= JWT.create().withClaim("id",user.getUserId()+"").withClaim("username",user.getUserName())
                .sign(Algorithm.HMAC256("emotion_analysis"));
        return token;
    }
    public static  String decodeJwt(String token)
    {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("emotion_analysis")).build();
        return jwtVerifier.verify(token).getClaim("id").asString();
    }
}
