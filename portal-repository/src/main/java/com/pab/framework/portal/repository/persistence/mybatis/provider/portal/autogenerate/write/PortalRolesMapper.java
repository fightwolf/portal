package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoles;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRolesExample;
import org.apache.ibatis.annotations.*;

public interface PortalRolesMapper {
    @DeleteProvider(type = PortalRolesSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalRolesExample example);

    @Delete({
            "delete from `portal_roles`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_roles` (`Id`, `role_code`, ",
            "`role_name`, `ar`, `describes`, ",
            "`status`, `creator_id`, ",
            "`creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{roleCode,jdbcType=VARCHAR}, ",
            "#{roleName,jdbcType=VARCHAR}, #{ar,jdbcType=INTEGER}, #{describes,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=INTEGER}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalRoles record);

    @InsertProvider(type = PortalRolesSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalRoles record);

    @UpdateProvider(type = PortalRolesSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalRoles record, @Param("example") PortalRolesExample example);

    @UpdateProvider(type = PortalRolesSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalRoles record, @Param("example") PortalRolesExample example);

    @UpdateProvider(type = PortalRolesSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalRoles record);

    @Update({
            "update `portal_roles`",
            "set `role_code` = #{roleCode,jdbcType=VARCHAR},",
            "`role_name` = #{roleName,jdbcType=VARCHAR},",
            "`ar` = #{ar,jdbcType=INTEGER},",
            "`describes` = #{describes,jdbcType=VARCHAR},",
            "`status` = #{status,jdbcType=INTEGER},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalRoles record);
}