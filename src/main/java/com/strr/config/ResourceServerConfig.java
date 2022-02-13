package com.strr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strr.common.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import java.io.PrintWriter;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().hasRole("ADMIN")
                .and()
                .formLogin()
                // 登录
                .loginProcessingUrl("/security/login")
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(Result.ok(authentication.getPrincipal())));
                    out.flush();
                    out.close();
                })
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(Result.error()));
                    out.flush();
                    out.close();
                })
                // 退出
                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(Result.ok()));
                    out.flush();
                    out.close();
                })
                // 禁用csrf
                .and()
                .csrf().disable()
                .exceptionHandling();
    }
}
