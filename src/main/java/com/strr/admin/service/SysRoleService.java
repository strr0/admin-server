package com.strr.admin.service;

import com.strr.admin.model.SysRole;
import com.strr.admin.model.SysRoleVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysRoleService {
    SysRole get(Integer id);

    List<SysRole> list(SysRoleVO param);

    int save(SysRole record);

    int remove(Integer id);

    int update(SysRole record);

    Page<SysRole> page(SysRoleVO param, Pageable pageable);

    /**
     * 更新角色权限
     * @param rid
     * @param oldAids
     * @param newAids
     * @return
     */
    void updateRel(Integer rid, Integer[] oldAids, Integer[] newAids);

    /**
     * 获取角色权限
     * @param rid
     * @return
     */
    List<Integer> listRelByRid(Integer rid);

    /**
     * 删除角色
     * @param id
     */
    void removeWithRel(Integer id);
}