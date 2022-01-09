package com.strr.admin.mapper;

import com.strr.admin.model.SysRole;
import com.strr.admin.model.SysRoleVO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SysRoleSqlProvider {
    public String countByParam(SysRoleVO param) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_role");
        applyWhere(sql, param);
        return sql.toString();
    }

    public String deleteByParam(SysRoleVO param) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_role");
        applyWhere(sql, param);
        return sql.toString();
    }

    public String insertSelective(SysRole record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_role");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSeq() != null) {
            sql.VALUES("seq", "#{seq,jdbcType=TINYINT}");
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
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByParam(SysRoleVO param) {
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("name");
        sql.SELECT("remark");
        sql.SELECT("seq");
        sql.SELECT("creator");
        sql.SELECT("create_time");
        sql.SELECT("updator");
        sql.SELECT("update_time");
        sql.SELECT("status");
        sql.FROM("sys_role");
        applyWhere(sql, param);
        
        return sql.toString();
    }

    public String updateByParamSelective(Map<String, Object> parameter) {
        SysRole record = (SysRole) parameter.get("record");
        SysRoleVO param = (SysRoleVO) parameter.get("param");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_role");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSeq() != null) {
            sql.SET("seq = #{record.seq,jdbcType=TINYINT}");
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
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, param);
        return sql.toString();
    }

    public String updateByParam(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("seq = #{record.seq,jdbcType=TINYINT}");
        sql.SET("creator = #{record.creator,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("updator = #{record.updator,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        
        SysRoleVO param = (SysRoleVO) parameter.get("param");
        applyWhere(sql, param);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysRole record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSeq() != null) {
            sql.SET("seq = #{seq,jdbcType=TINYINT}");
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
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    public String selectByParamSelective(Map<String, Object> parameter) {
        SysRoleVO param = (SysRoleVO) parameter.get("param");
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("name");
        sql.SELECT("remark");
        sql.SELECT("seq");
        sql.SELECT("creator");
        sql.SELECT("create_time");
        sql.SELECT("updator");
        sql.SELECT("update_time");
        sql.SELECT("status");
        sql.FROM("sys_role");
        applyWhere(sql, param);
        
        sql.LIMIT("#{pageable.pageNumber}, #{pageable.pageSize}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysRoleVO param) {
        if (param == null) {
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}