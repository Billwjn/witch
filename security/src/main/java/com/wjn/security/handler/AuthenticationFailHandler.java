package com.wjn.security.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {

        // 默认情况下，不管你是用户名不存在，密码错误，SS 都会报出 Bad credentials 异常信息
        Map<Object, Object> map = new HashMap<>();
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            map.put("code",500);
            map.put("msg","用户名或密码错误");
        } else if (e instanceof DisabledException) {
            map.put("code",500);
            map.put("msg","账户被禁用，请联系管理员");
        } else {
            map.put("code",500);
            map.put("msg","登录失败，其他内部错误");
        }
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Object o = JSONObject.toJSON(map);
        out.print(o.toString());
    }

}