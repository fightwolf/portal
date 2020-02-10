package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoleGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoleGroupExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalRoleGroupMapper {
    @SelectProvider(type = PortalRoleGroupSqlProvider.class, method = "countByExample")
    int countByExample(PortalRoleGroupExample example);

    @SelectProvider(type = PortalRoleGroupSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "group_code", property = "groupCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role_code", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalRoleGroup> selectByExample(PortalRoleGroupExample example);

    @Select({
            "select",
            "`Id`, `group_code`, `role_code`, `creator_id`, `creator_name`, `create_timestamp`, ",
            "`last_update_timestamp`",
            "from `portal_role_group`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "group_code", property = "groupCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role_code", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    PortalRoleGroup selectByPrimaryKey(Long id);
}