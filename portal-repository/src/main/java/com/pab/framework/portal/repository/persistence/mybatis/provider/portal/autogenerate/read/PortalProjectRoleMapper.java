package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRoleExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalProjectRoleMapper {
    @SelectProvider(type = PortalProjectRoleSqlProvider.class, method = "countByExample")
    int countByExample(PortalProjectRoleExample example);

    @SelectProvider(type = PortalProjectRoleSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "role_code", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "project_code", property = "projectCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalProjectRole> selectByExample(PortalProjectRoleExample example);

    @Select({
            "select",
            "`Id`, `role_code`, `project_code`, `creator_id`, `creator_name`, `create_timestamp`, ",
            "`last_update_timestamp`",
            "from `portal_project_role`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "role_code", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "project_code", property = "projectCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    PortalProjectRole selectByPrimaryKey(Long id);
}