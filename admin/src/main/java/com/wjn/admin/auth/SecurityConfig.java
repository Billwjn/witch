package com.wjn.admin.auth;

import com.wjn.admin.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    //匹配所有的请求
                    .anyRequest()
                    .authenticated()
                    .and()
                //使用表单登陆的方式（默认是HttpBasic的方式）
                .formLogin()
                    //.loginPage("/login.html")
                    //.loginProcessingUrl("/admin/login")
                    //.defaultSuccessUrl("/main.html")
                    //.failureUrl("/admin/loginError")
                    //.permitAll()
                    //.and()
                //.logout()
                    //.logoutUrl("/admin/logout")
                    //.permitAll()
         ;
    }
    @Autowired
    CustomUserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
