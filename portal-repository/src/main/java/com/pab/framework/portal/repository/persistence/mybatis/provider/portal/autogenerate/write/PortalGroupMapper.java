package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalGroupExample;
import org.apache.ibatis.annotations.*;

public interface PortalGroupMapper {
    @DeleteProvider(type = PortalGroupSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalGroupExample example);

    @Delete({
            "delete from `portal_group`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_group` (`Id`, `role_code`, ",
            "`role_name`, `ar`, `describes`, ",
            "`status`, `creator_id`, ",
            "`creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{roleCode,jdbcType=VARCHAR}, ",
            "#{roleName,jdbcType=VARCHAR}, #{ar,jdbcType=INTEGER}, #{describes,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=INTEGER}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalGroup record);

    @InsertProvider(type = PortalGroupSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalGroup record);

    @UpdateProvider(type = PortalGroupSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalGroup record, @Param("example") PortalGroupExample example);

    @UpdateProvider(type = PortalGroupSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalGroup record, @Param("example") PortalGroupExample example);

    @UpdateProvider(type = PortalGroupSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalGroup record);

    @Update({
            "update `portal_group`",
            "set `role_code` = #{roleCode,jdbcType=VARCHAR},",
            "`role_name` = #{roleName,jdbcType=VARCHAR},",
            "`ar` = #{ar,jdbcType=INTEGER},",
            "`describes` = #{describes,jdbcType=VARCHAR},",
            "`status` = #{status,jdbcType=INTEGER},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalGroup record);
}