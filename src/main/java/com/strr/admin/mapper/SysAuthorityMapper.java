package com.strr.admin.mapper;

import com.strr.admin.model.SysAuthority;
import com.strr.admin.model.SysAuthorityVO;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface SysAuthorityMapper {
    @SelectProvider(type=SysAuthoritySqlProvider.class, method="countByParam")
    long countByParam(SysAuthorityVO param);

    @DeleteProvider(type=SysAuthoritySqlProvider.class, method="deleteByParam")
    int deleteByParam(SysAuthorityVO param);

    @Delete({
        "delete from sys_authority",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_authority (id, url, ",
        "path, name, icon, ",
        "parent_id, is_menu, type, ",
        "func, creator, create_time, ",
        "updator, update_time, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{url,jdbcType=VARCHAR}, ",
        "#{path,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER}, #{isMenu,jdbcType=BIT}, #{type,jdbcType=VARCHAR}, ",
        "#{func,jdbcType=VARCHAR}, #{creator,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updator,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=BIT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(SysAuthority record);

    @InsertProvider(type=SysAuthoritySqlProvider.class, method="insertSelective")
    int insertSelective(SysAuthority record);

    @SelectProvider(type=SysAuthoritySqlProvider.class, method="selectByParam")
    List<SysAuthority> selectByParam(SysAuthorityVO param);

    @Select({
        "select",
        "id, url, path, name, icon, parent_id, is_menu, type, func, creator, create_time, ",
        "updator, update_time, status",
        "from sys_authority",
        "where id = #{id,jdbcType=INTEGER}"
    })
    SysAuthority selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysAuthoritySqlProvider.class, method="updateByParamSelective")
    int updateByParamSelective(@Param("record") SysAuthority record, @Param("param") SysAuthorityVO param);

    @UpdateProvider(type=SysAuthoritySqlProvider.class, method="updateByParam")
    int updateByParam(@Param("record") SysAuthority record, @Param("param") SysAuthorityVO param);

    @UpdateProvider(type=SysAuthoritySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysAuthority record);

    @Update({
        "update sys_authority",
        "set url = #{url,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "is_menu = #{isMenu,jdbcType=BIT},",
          "type = #{type,jdbcType=VARCHAR},",
          "func = #{func,jdbcType=VARCHAR},",
          "creator = #{creator,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updator = #{updator,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysAuthority record);

    @SelectProvider(type=SysAuthoritySqlProvider.class, method="selectByParamSelective")
    List<SysAuthority> selectByParamSelective(@Param("param") SysAuthorityVO param, @Param("pageable") Pageable pageable);

    /**
     * 获取用户权限
     * @param userId
     * @return
     */
    @Select({
            "select",
            "t1.id, t1.url, t1.path, t1.name, t1.icon, t1.parent_id, t1.is_menu, t1.type, t1.func, ",
            "t1.creator, t1.create_time, t1.updator, t1.update_time, t1.status",
            "from sys_authority t1",
            "where t1.id in (select distinct(t2.aid) from sys_rel_role_authority t2 left join sys_rel_user_role t3 on t2.rid = t3.rid where t3.uid = #{userId,jdbcType=INTEGER})"
    })
    List<SysAuthority> listByUserId(Integer userId);

    /**
     * 删除角色权限
     * @param aid
     * @return
     */
    @Delete({
            "delete from sys_rel_role_authority",
            "where aid = #{aid}"
    })
    int deleteRelByAid(Integer aid);
}