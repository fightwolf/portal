package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRoleExample;
import org.apache.ibatis.annotations.*;

public interface PortalProjectRoleMapper {
    @DeleteProvider(type = PortalProjectRoleSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalProjectRoleExample example);

    @Delete({
            "delete from `portal_project_role`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_project_role` (`Id`, `role_code`, ",
            "`project_code`, `creator_id`, ",
            "`creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{roleCode,jdbcType=VARCHAR}, ",
            "#{projectCode,jdbcType=VARCHAR}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalProjectRole record);

    @InsertProvider(type = PortalProjectRoleSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalProjectRole record);

    @UpdateProvider(type = PortalProjectRoleSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalProjectRole record, @Param("example") PortalProjectRoleExample example);

    @UpdateProvider(type = PortalProjectRoleSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalProjectRole record, @Param("example") PortalProjectRoleExample example);

    @UpdateProvider(type = PortalProjectRoleSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalProjectRole record);

    @Update({
            "update `portal_project_role`",
            "set `role_code` = #{roleCode,jdbcType=VARCHAR},",
            "`project_code` = #{projectCode,jdbcType=VARCHAR},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalProjectRole record);
}