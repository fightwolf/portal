package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoleGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoleGroupExample;
import org.apache.ibatis.annotations.*;

public interface PortalRoleGroupMapper {
    @DeleteProvider(type = PortalRoleGroupSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalRoleGroupExample example);

    @Delete({
            "delete from `portal_role_group`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_role_group` (`Id`, `group_code`, ",
            "`role_code`, `creator_id`, ",
            "`creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{groupCode,jdbcType=VARCHAR}, ",
            "#{roleCode,jdbcType=VARCHAR}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalRoleGroup record);

    @InsertProvider(type = PortalRoleGroupSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalRoleGroup record);

    @UpdateProvider(type = PortalRoleGroupSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalRoleGroup record, @Param("example") PortalRoleGroupExample example);

    @UpdateProvider(type = PortalRoleGroupSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalRoleGroup record, @Param("example") PortalRoleGroupExample example);

    @UpdateProvider(type = PortalRoleGroupSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalRoleGroup record);

    @Update({
            "update `portal_role_group`",
            "set `group_code` = #{groupCode,jdbcType=VARCHAR},",
            "`role_code` = #{roleCode,jdbcType=VARCHAR},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalRoleGroup record);
}