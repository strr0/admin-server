package com.strr.admin.controller;

import com.strr.admin.model.SysAuthority;
import com.strr.admin.model.SysAuthorityVO;
import com.strr.admin.model.SysUserDetails;
import com.strr.admin.service.SysAuthorityService;
import com.strr.admin.util.SysUtil;
import com.strr.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/sysAuthority")
public class SysAuthorityController {
    private final SysAuthorityService sysAuthorityService;

    @Autowired
    public SysAuthorityController(SysAuthorityService sysAuthorityService) {
        this.sysAuthorityService = sysAuthorityService;
    }

    @GetMapping("/get")
    public Result<SysAuthority> get(Integer id) {
        SysAuthority sysAuthority = sysAuthorityService.get(id);
        if (sysAuthority != null) {
            return Result.ok();
        }
        return Result.error();
    }

    @GetMapping("/list")
    public Result<List<SysAuthority>> list(SysAuthorityVO param) {
        List<SysAuthority> sysAuthorityList = sysAuthorityService.list(param);
        return Result.ok(sysAuthorityList);
    }

    @PostMapping("/save")
    public Result<SysAuthority> save(SysAuthority record) {
        if (sysAuthorityService.save(record) == 1) {
            return Result.ok(record);
        }
        return Result.error();
    }

    @DeleteMapping("/remove")
    public Result<Integer> remove(Integer id) {
        if (sysAuthorityService.remove(id) == 1) {
            return Result.ok();
        }
        return Result.error();
    }

    @PutMapping("/update")
    public Result<SysAuthority> update(SysAuthority record) {
        if (sysAuthorityService.update(record) == 1) {
            return Result.ok(record);
        }
        return Result.error();
    }

    @GetMapping("/page")
    public Page<SysAuthority> page(SysAuthorityVO param, Pageable pageable) {
        return sysAuthorityService.page(param, pageable);
    }

    /**
     * 菜单树
     * @param param
     * @return
     */
    @GetMapping("/menuTree")
    public Result<List<SysAuthorityVO>> menuTree(SysAuthorityVO param) {
        List<SysAuthority> sysAuthorityList = sysAuthorityService.list(param);
        return Result.ok(SysUtil.buildMenuTree(sysAuthorityList));
    }

    /**
     * 用户菜单树
     * @return
     */
    @GetMapping("/userMenuTree")
    public Result<List<SysAuthorityVO>> userMenuTree(@AuthenticationPrincipal SysUserDetails sysUserDetails) {
        List<SysAuthority> authorityList = sysUserDetails.getAuthorityList();
        return Result.ok(SysUtil.buildMenuTree(authorityList));
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    @DeleteMapping("/removeInfo")
    public Result<Void> removeInfo(Integer id) {
        sysAuthorityService.removeWithRel(id);
        return Result.ok();
    }
}