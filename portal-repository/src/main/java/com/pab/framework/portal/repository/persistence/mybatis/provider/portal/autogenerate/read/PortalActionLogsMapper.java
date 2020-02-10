package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalActionLogs;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalActionLogsExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalActionLogsMapper {
    @SelectProvider(type = PortalActionLogsSqlProvider.class, method = "countByExample")
    int countByExample(PortalActionLogsExample example);

    @SelectProvider(type = PortalActionLogsSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "operation_type", property = "operationType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "operation_name", property = "operationName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_code", property = "parentCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "describes", property = "describes", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ip", property = "ip", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalActionLogs> selectByExample(PortalActionLogsExample example);

    @Select({
            "select",
            "`Id`, `operation_type`, `operation_name`, `parent_code`, `describes`, `ip`, ",
            "`creator_id`, `creator_name`, `create_timestamp`, `last_update_timestamp`",
            "from `portal_action_logs`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "operation_type", property = "operationType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "operation_name", property = "operationName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_code", property = "parentCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "describes", property = "describes", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ip", property = "ip", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    PortalActionLogs selectByPrimaryKey(Long id);
}