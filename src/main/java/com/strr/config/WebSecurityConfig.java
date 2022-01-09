package com.strr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strr.admin.model.SysUserDetails;
import com.strr.admin.service.SysAuthorityService;
import com.strr.admin.service.SysUserService;
import com.strr.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.PrintWriter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final SysUserService sysUserService;
    private final SysAuthorityService sysAuthorityService;

    @Autowired
    public WebSecurityConfig(SysUserService sysUserService, SysAuthorityService sysAuthorityService) {
        this.sysUserService = sysUserService;
        this.sysAuthorityService = sysAuthorityService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            SysUserDetails sysUserDetails = sysUserService.getByUsername(username);
            if (sysUserDetails != null) {
                sysUserDetails.setAuthorityList(sysAuthorityService.listByUserId(sysUserDetails.getId()));
                return sysUserDetails;
            }
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 登录
                .loginProcessingUrl("/security/login")
                .successHandler(((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    // ok
                    out.write(new ObjectMapper().writeValueAsString(Result.ok(authentication.getPrincipal())));
                    out.flush();
                    out.close();
                }))
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    // error
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
                .exceptionHandling()
                // h2
                .and()
                .headers().frameOptions().sameOrigin();
    }
}
