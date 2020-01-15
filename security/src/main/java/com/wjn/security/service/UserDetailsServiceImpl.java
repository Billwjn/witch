package com.wjn.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 从数据库中获取用户信息，返回一个 UserDetails 对象，
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //将 user 对象转化为 UserDetails 对象
        String password = new BCryptPasswordEncoder().encode("root");
        return new User("root",password,new ArrayList<>());
    }
}