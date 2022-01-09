package com.strr.admin.controller;

import com.strr.admin.model.SysRole;
import com.strr.admin.model.SysRoleVO;
import com.strr.admin.service.SysRoleService;
import com.strr.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/sysRole")
public class SysRoleController {
    private final SysRoleService sysRoleService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @GetMapping("/get")
    public Result<SysRole> get(Integer id) {
        SysRole sysRole = sysRoleService.get(id);
        if (sysRole != null) {
            return Result.ok();
        }
        return Result.error();
    }

    @GetMapping("/list")
    public Result<List<SysRole>> list(SysRoleVO param) {
        List<SysRole> sysRoleList = sysRoleService.list(param);
        return Result.ok(sysRoleList);
    }

    @PostMapping("/save")
    public Result<SysRole> save(SysRole record) {
        if (sysRoleService.save(record) == 1) {
            return Result.ok(record);
        }
        return Result.error();
    }

    @DeleteMapping("/remove")
    public Result<Integer> remove(Integer id) {
        if (sysRoleService.remove(id) == 1) {
            return Result.ok();
        }
        return Result.error();
    }

    @PutMapping("/update")
    public Result<SysRole> update(SysRole record) {
        if (sysRoleService.update(record) == 1) {
            return Result.ok(record);
        }
        return Result.error();
    }

    @GetMapping("/page")
    public Page<SysRole> page(SysRoleVO param, Pageable pageable) {
        return sysRoleService.page(param, pageable);
    }

    /**
     * 更新角色权限
     * @param rid
     * @param oldAids
     * @param newAids
     * @return
     */
    @PostMapping("/updateRel")
    public Result<Void> updateRel(Integer rid, Integer[] oldAids, Integer[] newAids) {
        sysRoleService.updateRel(rid, oldAids, newAids);
        return Result.ok();
    }

    /**
     * 获取角色权限
     * @param rid
     * @return
     */
    @GetMapping("/listRelByRid")
    public Result<List<Integer>> listRelByRid(Integer rid) {
        List<Integer> data = sysRoleService.listRelByRid(rid);
        return Result.ok(data);
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @DeleteMapping("/removeInfo")
    public Result<Void> removeInfo(Integer id) {
        sysRoleService.removeWithRel(id);
        return Result.ok();
    }
}