package com.strr.admin.mapper;

import com.strr.admin.model.SysUser;
import com.strr.admin.model.SysUserVO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SysUserSqlProvider {
    public String countByParam(SysUserVO param) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_user");
        applyWhere(sql, param);
        return sql.toString();
    }

    public String deleteByParam(SysUserVO param) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_user");
        applyWhere(sql, param);
        return sql.toString();
    }

    public String insertSelective(SysUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.VALUES("avatar", "#{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginTime() != null) {
            sql.VALUES("login_time", "#{loginTime,jdbcType=TIMESTAMP}");
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

    public String selectByParam(SysUserVO param) {
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("username");
        sql.SELECT("password");
        sql.SELECT("nickname");
        sql.SELECT("email");
        sql.SELECT("avatar");
        sql.SELECT("remark");
        sql.SELECT("login_time");
        sql.SELECT("creator");
        sql.SELECT("create_time");
        sql.SELECT("updator");
        sql.SELECT("update_time");
        sql.SELECT("status");
        sql.FROM("sys_user");
        applyWhere(sql, param);
        
        return sql.toString();
    }

    public String updateByParamSelective(Map<String, Object> parameter) {
        SysUser record = (SysUser) parameter.get("record");
        SysUserVO param = (SysUserVO) parameter.get("param");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_user");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{record.username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.SET("avatar = #{record.avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginTime() != null) {
            sql.SET("login_time = #{record.loginTime,jdbcType=TIMESTAMP}");
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
        sql.UPDATE("sys_user");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("username = #{record.username,jdbcType=VARCHAR}");
        sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        sql.SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("avatar = #{record.avatar,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("login_time = #{record.loginTime,jdbcType=TIMESTAMP}");
        sql.SET("creator = #{record.creator,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("updator = #{record.updator,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=BIT}");
        
        SysUserVO param = (SysUserVO) parameter.get("param");
        applyWhere(sql, param);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysUser record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_user");
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.SET("avatar = #{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginTime() != null) {
            sql.SET("login_time = #{loginTime,jdbcType=TIMESTAMP}");
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
        SysUserVO param = (SysUserVO) parameter.get("param");
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("username");
        sql.SELECT("password");
        sql.SELECT("nickname");
        sql.SELECT("email");
        sql.SELECT("avatar");
        sql.SELECT("remark");
        sql.SELECT("login_time");
        sql.SELECT("creator");
        sql.SELECT("create_time");
        sql.SELECT("updator");
        sql.SELECT("update_time");
        sql.SELECT("status");
        sql.FROM("sys_user");
        applyWhere(sql, param);
        
        sql.LIMIT("#{pageable.pageNumber}, #{pageable.pageSize}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysUserVO param) {
        if (param == null) {
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}