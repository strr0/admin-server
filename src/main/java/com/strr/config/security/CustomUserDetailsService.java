package com.strr.config.security;

import com.strr.admin.mapper.SysAuthorityMapper;
import com.strr.admin.mapper.SysRoleMapper;
import com.strr.admin.mapper.SysUserMapper;
import com.strr.admin.model.SysUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final SysUserMapper sysUserMapper;
    private final SysRoleMapper sysRoleMapper;
    private final SysAuthorityMapper sysAuthorityMapper;

    @Autowired
    public CustomUserDetailsService(SysUserMapper sysUserMapper, SysRoleMapper sysRoleMapper, SysAuthorityMapper sysAuthorityMapper) {
        this.sysUserMapper = sysUserMapper;
        this.sysRoleMapper = sysRoleMapper;
        this.sysAuthorityMapper = sysAuthorityMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SysUserDetails> userDetailsList = sysUserMapper.getByUsername(username);
        if (!userDetailsList.isEmpty()) {
            SysUserDetails userDetails = userDetailsList.get(0);
            userDetails.setRoleList(sysRoleMapper.listByUserId(userDetails.getId()));
            userDetails.setAuthorityList(sysAuthorityMapper.listByUserId(userDetails.getId()));
            return userDetails;
        }
        throw new UsernameNotFoundException(String.format("User '%s' not found.", username));
    }
}
