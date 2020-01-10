package com.wjn.admin.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //这个方法里可以调用通过username查询数据库的方法
        //User userFromDatabase = userRepository.findOneByLogin(login);
        //if (userFromDatabase == null) {
            //log.warn("User: {} not found", login);
            //throw new UsernameNotFoundException("User " + login + " was not found in db");
            //这里找不到必须抛异常
        //}
        //设置角色
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //用加密方法给密码加密，注册的时候用
        //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //String encode = bCryptPasswordEncoder.encode("root");
        //这个密码是root加密后的密文，明文是root
        return new User("root","$2a$10$iU.PbZ9Id.4.sqGzPVaSvOKkmqS97K4Wt.LUbKFNMWexfap3hBGvO",grantedAuthorities);
    }
}
