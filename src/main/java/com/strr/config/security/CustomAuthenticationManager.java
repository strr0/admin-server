package com.strr.config.security;

import com.strr.admin.mapper.SysUserMapper;
import com.strr.admin.model.SysUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

//@Component
public class CustomAuthenticationManager implements AuthenticationManager {
    private final SysUserMapper sysUserMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationManager(SysUserMapper sysUserMapper, PasswordEncoder passwordEncoder) {
        this.sysUserMapper = sysUserMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户名不能为空.");
        }
        if (StringUtils.isEmpty(password)) {
            throw new BadCredentialsException("密码不能为空.");
        }
        // 获取用户信息
        List<SysUserDetails> userDetailsList = sysUserMapper.getByUsername(username);
        if (userDetailsList.isEmpty()) {
            throw new UsernameNotFoundException(String.format("未找到用户[%s].", username));
        }
        SysUserDetails userDetails = userDetailsList.get(0);
        // 用户密码匹配
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("密码错误.");
        }
        return new UsernamePasswordAuthenticationToken(username, password, null);
    }
}
