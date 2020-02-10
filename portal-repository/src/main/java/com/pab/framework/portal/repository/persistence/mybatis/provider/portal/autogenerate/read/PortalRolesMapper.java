package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoles;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRolesExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalRolesMapper {
    @SelectProvider(type = PortalRolesSqlProvider.class, method = "countByExample")
    int countByExample(PortalRolesExample example);

    @SelectProvider(type = PortalRolesSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "role_code", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "describes", property = "describes", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalRoles> selectByExample(PortalRolesExample example);

    @Select({
            "select",
            "`Id`, `role_code`, `role_name`, `ar`, `describes`, `status`, `creator_id`, `creator_name`, ",
            "`create_timestamp`, `last_update_timestamp`",
            "from `portal_roles`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "role_code", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "describes", property = "describes", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    PortalRoles selectByPrimaryKey(Long id);
}