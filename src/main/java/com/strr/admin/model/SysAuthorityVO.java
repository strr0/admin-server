package com.strr.admin.model;

import java.util.List;

public class SysAuthorityVO extends SysAuthority {
    private String parentName;

    private List<SysAuthorityVO> children;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<SysAuthorityVO> getChildren() {
        return children;
    }

    public void setChildren(List<SysAuthorityVO> children) {
        this.children = children;
    }
}