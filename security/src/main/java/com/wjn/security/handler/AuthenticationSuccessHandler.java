package com.wjn.security.handler;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Slf4j
@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String username = ((UserDetails)authentication.getPrincipal()).getUsername();
        Collection<? extends GrantedAuthority> authorities = ((UserDetails) authentication.getPrincipal()).getAuthorities();
        List<String> list = new ArrayList<>();
        for(GrantedAuthority g : authorities){
            list.add(g.getAuthority());
        }
        //登陆成功生成token
        String  token = UUID.randomUUID().toString().replace("-", "");
        //token 需要保存至服务器一份，实现方式：redis or jwt输出到浏览器
        Map<Object, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","登陆成功");
        map.put("username",username);
        map.put("token",token);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        Object o = JSONObject.toJSON(map);
        System.out.println(o);
        out.print(o.toString());
    }
}
