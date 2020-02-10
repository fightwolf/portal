package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserGroupExample;
import org.apache.ibatis.annotations.*;

public interface PortalUserGroupMapper {
    @DeleteProvider(type = PortalUserGroupSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalUserGroupExample example);

    @Delete({
            "delete from `portal_user_group`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_user_group` (`Id`, `user_code`, ",
            "`role_code`, `creator_id`, ",
            "`creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{userCode,jdbcType=VARCHAR}, ",
            "#{roleCode,jdbcType=VARCHAR}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalUserGroup record);

    @InsertProvider(type = PortalUserGroupSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalUserGroup record);

    @UpdateProvider(type = PortalUserGroupSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalUserGroup record, @Param("example") PortalUserGroupExample example);

    @UpdateProvider(type = PortalUserGroupSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalUserGroup record, @Param("example") PortalUserGroupExample example);

    @UpdateProvider(type = PortalUserGroupSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalUserGroup record);

    @Update({
            "update `portal_user_group`",
            "set `user_code` = #{userCode,jdbcType=VARCHAR},",
            "`role_code` = #{roleCode,jdbcType=VARCHAR},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalUserGroup record);
}