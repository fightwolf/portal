package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalModule;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalModuleExample;
import org.apache.ibatis.annotations.*;

public interface PortalModuleMapper {
    @DeleteProvider(type = PortalModuleSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalModuleExample example);

    @Delete({
            "delete from `portal_module`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_module` (`Id`, `module_name`, ",
            "`module_code`, `parent_code`, ",
            "`icon`, `link`, `describes`, ",
            "`ar`, `status`, `creator_id`, ",
            "`creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{moduleName,jdbcType=VARCHAR}, ",
            "#{moduleCode,jdbcType=VARCHAR}, #{parentCode,jdbcType=VARCHAR}, ",
            "#{icon,jdbcType=VARCHAR}, #{link,jdbcType=VARCHAR}, #{describes,jdbcType=VARCHAR}, ",
            "#{ar,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalModule record);

    @InsertProvider(type = PortalModuleSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalModule record);

    @UpdateProvider(type = PortalModuleSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalModule record, @Param("example") PortalModuleExample example);

    @UpdateProvider(type = PortalModuleSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalModule record, @Param("example") PortalModuleExample example);

    @UpdateProvider(type = PortalModuleSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalModule record);

    @Update({
            "update `portal_module`",
            "set `module_name` = #{moduleName,jdbcType=VARCHAR},",
            "`module_code` = #{moduleCode,jdbcType=VARCHAR},",
            "`parent_code` = #{parentCode,jdbcType=VARCHAR},",
            "`icon` = #{icon,jdbcType=VARCHAR},",
            "`link` = #{link,jdbcType=VARCHAR},",
            "`describes` = #{describes,jdbcType=VARCHAR},",
            "`ar` = #{ar,jdbcType=INTEGER},",
            "`status` = #{status,jdbcType=INTEGER},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalModule record);
}