package com.strr.admin.service.impl;

import com.strr.admin.mapper.SysUserMapper;
import com.strr.admin.model.SysUser;
import com.strr.admin.model.SysUserDetails;
import com.strr.admin.model.SysUserVO;
import com.strr.admin.service.SysUserService;
import com.strr.admin.util.SysUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    private final SysUserMapper sysUserMapper;

    @Autowired
    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    public SysUser get(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    public List<SysUser> list(SysUserVO param) {
        return sysUserMapper.selectByParam(param);
    }

    public int save(SysUser record) {
        return sysUserMapper.insert(record);
    }

    public int remove(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    public int update(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    public Page<SysUser> page(SysUserVO param, Pageable pageable) {
        long count = sysUserMapper.countByParam(param);
        List<SysUser> list = sysUserMapper.selectByParamSelective(param, pageable);
        return new PageImpl<>(list, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), count);
    }

    /**
     * 保存用户
     * @param sysUser
     * @param oldRids
     * @param newRids
     */
    @Override
    public void saveWithRel(SysUser sysUser, Integer[] oldRids, Integer[] newRids) {
        if (sysUser.getId() == null) {
            if (sysUser.getPassword() == null) {
                sysUser.setPassword(new BCryptPasswordEncoder().encode("abc123"));
            }
            save(sysUser);
        } else {
            update(sysUser);
        }
        for (Integer rid : SysUtil.subtraction(oldRids, newRids)) {
            sysUserMapper.removeRel(sysUser.getId(), rid);
        }
        for (Integer rid : SysUtil.subtraction(newRids, oldRids)) {
            sysUserMapper.saveRel(sysUser.getId(), rid);
        }
    }

    /**
     * 获取用户角色
     * @param uid
     * @return
     */
    @Override
    public List<Integer> listRelByUid(Integer uid) {
        return sysUserMapper.listRelByUid(uid);
    }

    /**
     * 获取用户
     * @param username
     * @return
     */
    @Override
    public SysUserDetails getByUsername(String username) {
        List<SysUserDetails> userList = sysUserMapper.getByUsername(username);
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void removeWithRel(Integer id) {
        sysUserMapper.deleteByPrimaryKey(id);
        sysUserMapper.deleteRelByUid(id);
    }
}