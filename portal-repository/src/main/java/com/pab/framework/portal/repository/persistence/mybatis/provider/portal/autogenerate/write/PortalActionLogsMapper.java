package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalActionLogs;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalActionLogsExample;
import org.apache.ibatis.annotations.*;

public interface PortalActionLogsMapper {
    @DeleteProvider(type = PortalActionLogsSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalActionLogsExample example);

    @Delete({
            "delete from `portal_action_logs`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_action_logs` (`Id`, `operation_type`, ",
            "`operation_name`, `parent_code`, ",
            "`describes`, `ip`, `creator_id`, ",
            "`creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{operationType,jdbcType=VARCHAR}, ",
            "#{operationName,jdbcType=VARCHAR}, #{parentCode,jdbcType=VARCHAR}, ",
            "#{describes,jdbcType=VARCHAR}, #{ip,jdbcType=VARCHAR}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalActionLogs record);

    @InsertProvider(type = PortalActionLogsSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalActionLogs record);

    @UpdateProvider(type = PortalActionLogsSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalActionLogs record, @Param("example") PortalActionLogsExample example);

    @UpdateProvider(type = PortalActionLogsSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalActionLogs record, @Param("example") PortalActionLogsExample example);

    @UpdateProvider(type = PortalActionLogsSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalActionLogs record);

    @Update({
            "update `portal_action_logs`",
            "set `operation_type` = #{operationType,jdbcType=VARCHAR},",
            "`operation_name` = #{operationName,jdbcType=VARCHAR},",
            "`parent_code` = #{parentCode,jdbcType=VARCHAR},",
            "`describes` = #{describes,jdbcType=VARCHAR},",
            "`ip` = #{ip,jdbcType=VARCHAR},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalActionLogs record);
}