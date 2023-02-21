package com.neusoft.emotion_analysis.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {
    private User user;
    private List<String> authority;

    public LoginUser(User user, List<String> role)
    {
        this.user=user;
        this.authority=role;
    }

    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(authorities==null)
        {
            Stream<String> stream=authority.stream();
            authorities = stream.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }
    //过期时间
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //用户是否被锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //指密码是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 用户注销
    @Override
    public boolean isEnabled() {
        return true;
    }
}
