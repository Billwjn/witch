package com.wjn.auth.web;

import com.wjn.auth.entity.SysUser;
import com.wjn.auth.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public String login(@RequestBody SysUser sysUser, HttpServletRequest request){
        final UserDetails userDetails = userDetailsService.loadUserByUsername(sysUser.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    @PostMapping("haha")
    public String haha(){
        UserDetails userDetails = (UserDetails) org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "haha:"+userDetails.getUsername()+","+userDetails.getPassword();
    }
}