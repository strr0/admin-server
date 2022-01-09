package com.strr.admin.mapper;

import com.strr.admin.model.SysAuthority;
import com.strr.admin.model.SysAuthorityVO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SysAuthoritySqlProvider {
    public String countByParam(SysAuthorityVO param) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_authority");
        applyWhere(sql, param);
        return sql.toString();
    }

    public String deleteByParam(SysAuthorityVO param) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_authority");
        applyWhere(sql, param);
        return sql.toString();
    }

    public String insertSelective(SysAuthority record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_authority");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.VALUES("path", "#{path,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getIsMenu() != null) {
            sql.VALUES("is_menu", "#{isMenu,jdbcType=BIT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getFunc() != null) {
            sql.VALUES("func", "#{func,jdbcType=VARCHAR}");
        }
        
        if (record.getCreator() != null) {
            sql.VALUES("creator", "#{creator,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdator() != null) {
            sql.VALUES("updator", "#{updator,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String selectByParam(SysAuthorityVO param) {
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("url");
        sql.SELECT("path");
        sql.SELECT("name");
        sql.SELECT("icon");
        sql.SELECT("parent_id");
        sql.SELECT("is_menu");
        sql.SELECT("type");
        sql.SELECT("func");
        sql.SELECT("creator");
        sql.SELECT("create_time");
        sql.SELECT("updator");
        sql.SELECT("update_time");
        sql.SELECT("status");
        sql.FROM("sys_authority");
        applyWhere(sql, param);
        
        return sql.toString();
    }

    public String updateByParamSelective(Map<String, Object> parameter) {
        SysAuthority record = (SysAuthority) parameter.get("record");
        SysAuthorityVO param = (SysAuthorityVO) parameter.get("param");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_authority");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("path = #{record.path,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        }
        
        if (record.getIsMenu() != null) {
            sql.SET("is_menu = #{record.isMenu,jdbcType=BIT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getFunc() != null) {
            sql.SET("func = #{record.func,jdbcType=VARCHAR}");
        }
        
        if (record.getCreator() != null) {
            sql.SET("creator = #{record.creator,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdator() != null) {
            sql.SET("updator = #{record.updator,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=BIT}");
        }
        
        applyWhere(sql, param);
        return sql.toString();
    }

    public String updateByParam(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_authority");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        sql.SET("path = #{record.path,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        sql.SET("is_menu = #{record.isMenu,jdbcType=BIT}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("func = #{record.func,jdbcType=VARCHAR}");
        sql.SET("creator = #{record.creator,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("updator = #{record.updator,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=BIT}");
        
        SysAuthorityVO param = (SysAuthorityVO) parameter.get("param");
        applyWhere(sql, param);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysAuthority record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_authority");
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("path = #{path,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getIsMenu() != null) {
            sql.SET("is_menu = #{isMenu,jdbcType=BIT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getFunc() != null) {
            sql.SET("func = #{func,jdbcType=VARCHAR}");
        }
        
        if (record.getCreator() != null) {
            sql.SET("creator = #{creator,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdator() != null) {
            sql.SET("updator = #{updator,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=BIT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    public String selectByParamSelective(Map<String, Object> parameter) {
        SysAuthorityVO param = (SysAuthorityVO) parameter.get("param");
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("url");
        sql.SELECT("path");
        sql.SELECT("name");
        sql.SELECT("icon");
        sql.SELECT("parent_id");
        sql.SELECT("is_menu");
        sql.SELECT("type");
        sql.SELECT("func");
        sql.SELECT("creator");
        sql.SELECT("create_time");
        sql.SELECT("updator");
        sql.SELECT("update_time");
        sql.SELECT("status");
        sql.FROM("sys_authority");
        applyWhere(sql, param);
        
        sql.LIMIT("#{pageable.pageNumber}, #{pageable.pageSize}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysAuthorityVO param) {
        if (param == null) {
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}