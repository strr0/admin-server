package com.strr.admin.mapper;

import com.strr.admin.model.SysRole;
import com.strr.admin.model.SysRoleVO;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface SysRoleMapper {
    @SelectProvider(type=SysRoleSqlProvider.class, method="countByParam")
    long countByParam(SysRoleVO param);

    @DeleteProvider(type=SysRoleSqlProvider.class, method="deleteByParam")
    int deleteByParam(SysRoleVO param);

    @Delete({
        "delete from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_role (id, name, ",
        "remark, seq, creator, ",
        "create_time, updator, ",
        "update_time, status)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{seq,jdbcType=TINYINT}, #{creator,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updator,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(SysRole record);

    @InsertProvider(type=SysRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysRole record);

    @SelectProvider(type=SysRoleSqlProvider.class, method="selectByParam")
    List<SysRole> selectByParam(SysRoleVO param);

    @Select({
        "select",
        "id, name, remark, seq, creator, create_time, updator, update_time, status",
        "from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    SysRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByParamSelective")
    int updateByParamSelective(@Param("record") SysRole record, @Param("param") SysRoleVO param);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByParam")
    int updateByParam(@Param("record") SysRole record, @Param("param") SysRoleVO param);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sys_role",
        "set name = #{name,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "seq = #{seq,jdbcType=TINYINT},",
          "creator = #{creator,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updator = #{updator,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysRole record);

    @SelectProvider(type=SysRoleSqlProvider.class, method="selectByParamSelective")
    List<SysRole> selectByParamSelective(@Param("param") SysRoleVO param, @Param("pageable") Pageable pageable);

    /**
     * 添加角色权限
     * @param rid
     * @param aid
     * @return
     */
    @Insert({
            "insert into sys_rel_role_authority",
            "values(#{rid}, #{aid})"
    })
    int saveRel(@Param("rid") Integer rid, @Param("aid") Integer aid);

    /**
     * 删除角色权限
     * @param rid
     * @param aid
     * @return
     */
    @Delete({
            "delete sys_rel_role_authority",
            "where rid = #{rid} and aid = #{aid}"
    })
    int removeRel(@Param("rid") Integer rid, @Param("aid") Integer aid);

    /**
     * 获取角色权限
     * @param rid
     * @return
     */
    @Select({
            "select aid from sys_rel_role_authority where rid = #{rid}"
    })
    List<Integer> listRelByRid(Integer rid);

    /**
     * 删除角色权限
     * @param rid
     * @return
     */
    @Delete({
            "delete from sys_rel_role_authority",
            "where rid = #{rid}"
    })
    int deleteRARelByRid(Integer rid);

    /**
     * 删除用户角色
     * @param rid
     * @return
     */
    @Delete({
            "delete from sys_rel_user_role",
            "where rid = #{rid}"
    })
    int deleteURRelByRid(Integer rid);
}