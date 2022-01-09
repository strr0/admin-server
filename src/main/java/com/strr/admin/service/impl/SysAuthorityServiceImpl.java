package com.strr.admin.service.impl;

import com.strr.admin.mapper.SysAuthorityMapper;
import com.strr.admin.model.SysAuthority;
import com.strr.admin.model.SysAuthorityVO;
import com.strr.admin.service.SysAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysAuthorityServiceImpl implements SysAuthorityService {
    private final SysAuthorityMapper sysAuthorityMapper;

    @Autowired
    public SysAuthorityServiceImpl(SysAuthorityMapper sysAuthorityMapper) {
        this.sysAuthorityMapper = sysAuthorityMapper;
    }

    public SysAuthority get(Integer id) {
        return sysAuthorityMapper.selectByPrimaryKey(id);
    }

    public List<SysAuthority> list(SysAuthorityVO param) {
        return sysAuthorityMapper.selectByParam(param);
    }

    public int save(SysAuthority record) {
        return sysAuthorityMapper.insert(record);
    }

    public int remove(Integer id) {
        return sysAuthorityMapper.deleteByPrimaryKey(id);
    }

    public int update(SysAuthority record) {
        return sysAuthorityMapper.updateByPrimaryKey(record);
    }

    public Page<SysAuthority> page(SysAuthorityVO param, Pageable pageable) {
        long count = sysAuthorityMapper.countByParam(param);
        List<SysAuthority> list = sysAuthorityMapper.selectByParamSelective(param, pageable);
        return new PageImpl<>(list, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), count);
    }

    /**
     * 获取用户权限
     * @param userId
     * @return
     */
    @Override
    public List<SysAuthority> listByUserId(Integer userId) {
        return sysAuthorityMapper.listByUserId(userId);
    }

    /**
     * 删除权限
     * @param id
     */
    @Override
    public void removeWithRel(Integer id) {
        sysAuthorityMapper.deleteByPrimaryKey(id);
        sysAuthorityMapper.deleteRelByAid(id);
    }
}