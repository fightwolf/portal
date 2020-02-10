package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserRoleExample;
import org.apache.ibatis.annotations.*;

public interface PortalUserRoleMapper {
    @DeleteProvider(type = PortalUserRoleSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalUserRoleExample example);

    @Delete({
            "delete from `portal_user_role`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_user_role` (`Id`, `user_code`, ",
            "`role_code`, `creator_id`, ",
            "`creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{userCode,jdbcType=VARCHAR}, ",
            "#{roleCode,jdbcType=VARCHAR}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalUserRole record);

    @InsertProvider(type = PortalUserRoleSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalUserRole record);

    @UpdateProvider(type = PortalUserRoleSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalUserRole record, @Param("example") PortalUserRoleExample example);

    @UpdateProvider(type = PortalUserRoleSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalUserRole record, @Param("example") PortalUserRoleExample example);

    @UpdateProvider(type = PortalUserRoleSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalUserRole record);

    @Update({
            "update `portal_user_role`",
            "set `user_code` = #{userCode,jdbcType=VARCHAR},",
            "`role_code` = #{roleCode,jdbcType=VARCHAR},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalUserRole record);
}