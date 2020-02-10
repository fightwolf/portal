package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProject;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectExample;
import org.apache.ibatis.annotations.*;

public interface PortalProjectMapper {
    @DeleteProvider(type = PortalProjectSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalProjectExample example);

    @Delete({
            "delete from `portal_project`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_project` (`Id`, `project_code`, ",
            "`project_name`, `project_type`, ",
            "`parent_code`, `url`, ",
            "`url_name`, `describes`, ",
            "`creator_id`, `creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{projectCode,jdbcType=VARCHAR}, ",
            "#{projectName,jdbcType=VARCHAR}, #{projectType,jdbcType=INTEGER}, ",
            "#{parentCode,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
            "#{urlName,jdbcType=VARCHAR}, #{describes,jdbcType=VARCHAR}, ",
            "#{creatorId,jdbcType=VARCHAR}, #{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalProject record);

    @InsertProvider(type = PortalProjectSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalProject record);

    @UpdateProvider(type = PortalProjectSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalProject record, @Param("example") PortalProjectExample example);

    @UpdateProvider(type = PortalProjectSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalProject record, @Param("example") PortalProjectExample example);

    @UpdateProvider(type = PortalProjectSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalProject record);

    @Update({
            "update `portal_project`",
            "set `project_code` = #{projectCode,jdbcType=VARCHAR},",
            "`project_name` = #{projectName,jdbcType=VARCHAR},",
            "`project_type` = #{projectType,jdbcType=INTEGER},",
            "`parent_code` = #{parentCode,jdbcType=VARCHAR},",
            "`url` = #{url,jdbcType=VARCHAR},",
            "`url_name` = #{urlName,jdbcType=VARCHAR},",
            "`describes` = #{describes,jdbcType=VARCHAR},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalProject record);
}