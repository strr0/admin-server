package com.strr.admin.mapper;

import com.strr.admin.model.SysUser;
import com.strr.admin.model.SysUserDetails;
import com.strr.admin.model.SysUserVO;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface SysUserMapper {
    @SelectProvider(type=SysUserSqlProvider.class, method="countByParam")
    long countByParam(SysUserVO param);

    @DeleteProvider(type=SysUserSqlProvider.class, method="deleteByParam")
    int deleteByParam(SysUserVO param);

    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_user (id, username, ",
        "password, nickname, ",
        "email, avatar, remark, ",
        "login_time, creator, ",
        "create_time, updator, ",
        "update_time, status)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{loginTime,jdbcType=TIMESTAMP}, #{creator,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updator,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{status,jdbcType=BIT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(SysUser record);

    @InsertProvider(type=SysUserSqlProvider.class, method="insertSelective")
    int insertSelective(SysUser record);

    @SelectProvider(type=SysUserSqlProvider.class, method="selectByParam")
    List<SysUser> selectByParam(SysUserVO param);

    @Select({
        "select",
        "id, username, password, nickname, email, avatar, remark, login_time, creator, ",
        "create_time, updator, update_time, status",
        "from sys_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    SysUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysUserSqlProvider.class, method="updateByParamSelective")
    int updateByParamSelective(@Param("record") SysUser record, @Param("param") SysUserVO param);

    @UpdateProvider(type=SysUserSqlProvider.class, method="updateByParam")
    int updateByParam(@Param("record") SysUser record, @Param("param") SysUserVO param);

    @UpdateProvider(type=SysUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysUser record);

    @Update({
        "update sys_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "login_time = #{loginTime,jdbcType=TIMESTAMP},",
          "creator = #{creator,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updator = #{updator,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysUser record);

    @SelectProvider(type=SysUserSqlProvider.class, method="selectByParamSelective")
    List<SysUser> selectByParamSelective(@Param("param") SysUserVO param, @Param("pageable") Pageable pageable);

    /**
     * 保存用户角色
     * @param uid
     * @param rid
     * @return
     */
    @Insert({
            "insert into sys_rel_user_role",
            "values(#{uid}, #{rid})"
    })
    int saveRel(@Param("uid") Integer uid, @Param("rid") Integer rid);

    /**
     * 删除用户角色
     * @param uid
     * @param rid
     * @return
     */
    @Delete({
            "delete sys_rel_user_role",
            "where uid = #{uid} and rid = #{rid}"
    })
    int removeRel(@Param("uid") Integer uid, @Param("rid") Integer rid);

    /**
     * 获取用户角色
     * @param uid
     * @return
     */
    @Select({
            "select rid from sys_rel_user_role where uid = #{uid}"
    })
    List<Integer> listRelByUid(Integer uid);

    /**
     * 获取用户
     * @param username
     * @return
     */
    @Select({
            "select",
            "id, username, password, nickname, email, avatar, remark, login_time, creator, ",
            "create_time, updator, update_time, status",
            "from sys_user",
            "where username = #{username}"
    })
    List<SysUserDetails> getByUsername(String username);

    /**
     * 删除用户角色
     * @param uid
     * @return
     */
    @Delete({
            "delete from sys_rel_user_role",
            "where uid = #{uid}"
    })
    int deleteRelByUid(Integer uid);
}