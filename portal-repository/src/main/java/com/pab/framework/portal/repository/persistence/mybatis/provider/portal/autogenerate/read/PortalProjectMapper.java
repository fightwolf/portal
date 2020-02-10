package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProject;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalProjectMapper {
    @SelectProvider(type = PortalProjectSqlProvider.class, method = "countByExample")
    int countByExample(PortalProjectExample example);

    @SelectProvider(type = PortalProjectSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "project_code", property = "projectCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "project_name", property = "projectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "project_type", property = "projectType", jdbcType = JdbcType.INTEGER),
            @Result(column = "parent_code", property = "parentCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url_name", property = "urlName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "describes", property = "describes", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalProject> selectByExample(PortalProjectExample example);

    @Select({
            "select",
            "`Id`, `project_code`, `project_name`, `project_type`, `parent_code`, `url`, ",
            "`url_name`, `describes`, `creator_id`, `creator_name`, `create_timestamp`, `last_update_timestamp`",
            "from `portal_project`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "project_code", property = "projectCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "project_name", property = "projectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "project_type", property = "projectType", jdbcType = JdbcType.INTEGER),
            @Result(column = "parent_code", property = "parentCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url_name", property = "urlName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "describes", property = "describes", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    PortalProject selectByPrimaryKey(Long id);
}