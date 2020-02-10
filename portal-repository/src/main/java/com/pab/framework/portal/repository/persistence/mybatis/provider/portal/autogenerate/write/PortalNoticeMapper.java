package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNotice;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNoticeExample;
import org.apache.ibatis.annotations.*;

public interface PortalNoticeMapper {
    @DeleteProvider(type = PortalNoticeSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalNoticeExample example);

    @Delete({
            "delete from `portal_notice`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_notice` (`Id`, `title`, ",
            "`sub_title`, `position_id`, ",
            "`position_name`, `icon`, ",
            "`link`, `begin_times`, ",
            "`end_times`, `ar`, ",
            "`status`, `creator_id`, ",
            "`creator_name`, `contents`)",
            "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
            "#{subTitle,jdbcType=VARCHAR}, #{positionId,jdbcType=INTEGER}, ",
            "#{positionName,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, ",
            "#{link,jdbcType=VARCHAR}, #{beginTimes,jdbcType=TIMESTAMP}, ",
            "#{endTimes,jdbcType=TIMESTAMP}, #{ar,jdbcType=INTEGER}, ",
            "#{status,jdbcType=INTEGER}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR}, #{contents,jdbcType=LONGVARBINARY})"
    })
    int insert(PortalNotice record);

    @InsertProvider(type = PortalNoticeSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalNotice record);

    @UpdateProvider(type = PortalNoticeSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalNotice record, @Param("example") PortalNoticeExample example);

    @UpdateProvider(type = PortalNoticeSqlProvider.class, method = "updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") PortalNotice record, @Param("example") PortalNoticeExample example);

    @UpdateProvider(type = PortalNoticeSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalNotice record, @Param("example") PortalNoticeExample example);

    @UpdateProvider(type = PortalNoticeSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalNotice record);

    @Update({
            "update `portal_notice`",
            "set `title` = #{title,jdbcType=VARCHAR},",
            "`sub_title` = #{subTitle,jdbcType=VARCHAR},",
            "`position_id` = #{positionId,jdbcType=INTEGER},",
            "`position_name` = #{positionName,jdbcType=VARCHAR},",
            "`icon` = #{icon,jdbcType=VARCHAR},",
            "`link` = #{link,jdbcType=VARCHAR},",
            "`begin_times` = #{beginTimes,jdbcType=TIMESTAMP},",
            "`end_times` = #{endTimes,jdbcType=TIMESTAMP},",
            "`ar` = #{ar,jdbcType=INTEGER},",
            "`status` = #{status,jdbcType=INTEGER},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR},",
            "`contents` = #{contents,jdbcType=LONGVARBINARY}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(PortalNotice record);

    @Update({
            "update `portal_notice`",
            "set `title` = #{title,jdbcType=VARCHAR},",
            "`sub_title` = #{subTitle,jdbcType=VARCHAR},",
            "`position_id` = #{positionId,jdbcType=INTEGER},",
            "`position_name` = #{positionName,jdbcType=VARCHAR},",
            "`icon` = #{icon,jdbcType=VARCHAR},",
            "`link` = #{link,jdbcType=VARCHAR},",
            "`begin_times` = #{beginTimes,jdbcType=TIMESTAMP},",
            "`end_times` = #{endTimes,jdbcType=TIMESTAMP},",
            "`ar` = #{ar,jdbcType=INTEGER},",
            "`status` = #{status,jdbcType=INTEGER},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalNotice record);
}