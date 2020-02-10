package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserGroupExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalUserGroupMapper {
    @SelectProvider(type = PortalUserGroupSqlProvider.class, method = "countByExample")
    int countByExample(PortalUserGroupExample example);

    @SelectProvider(type = PortalUserGroupSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_code", property = "userCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role_code", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalUserGroup> selectByExample(PortalUserGroupExample example);

    @Select({
            "select",
            "`Id`, `user_code`, `role_code`, `creator_id`, `creator_name`, `create_timestamp`, ",
            "`last_update_timestamp`",
            "from `portal_user_group`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_code", property = "userCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role_code", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    PortalUserGroup selectByPrimaryKey(Long id);
}