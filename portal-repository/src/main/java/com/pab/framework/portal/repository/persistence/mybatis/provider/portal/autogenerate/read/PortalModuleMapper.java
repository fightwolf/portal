package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalModule;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalModuleExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalModuleMapper {
    @SelectProvider(type = PortalModuleSqlProvider.class, method = "countByExample")
    int countByExample(PortalModuleExample example);

    @SelectProvider(type = PortalModuleSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "module_name", property = "moduleName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "module_code", property = "moduleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_code", property = "parentCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
            @Result(column = "describes", property = "describes", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalModule> selectByExample(PortalModuleExample example);

    @Select({
            "select",
            "`Id`, `module_name`, `module_code`, `parent_code`, `icon`, `link`, `describes`, ",
            "`ar`, `status`, `creator_id`, `creator_name`, `create_timestamp`, `last_update_timestamp`",
            "from `portal_module`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "module_name", property = "moduleName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "module_code", property = "moduleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_code", property = "parentCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
            @Result(column = "describes", property = "describes", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    PortalModule selectByPrimaryKey(Long id);
}