package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNotice;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNoticeExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalNoticeMapper {
    @SelectProvider(type = PortalNoticeSqlProvider.class, method = "countByExample")
    int countByExample(PortalNoticeExample example);

    @SelectProvider(type = PortalNoticeSqlProvider.class, method = "selectByExampleWithBLOBs")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sub_title", property = "subTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "position_id", property = "positionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "position_name", property = "positionName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
            @Result(column = "begin_times", property = "beginTimes", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "end_times", property = "endTimes", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "contents", property = "contents", jdbcType = JdbcType.LONGVARBINARY)
    })
    List<PortalNotice> selectByExampleWithBLOBs(PortalNoticeExample example);

    @SelectProvider(type = PortalNoticeSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sub_title", property = "subTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "position_id", property = "positionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "position_name", property = "positionName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
            @Result(column = "begin_times", property = "beginTimes", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "end_times", property = "endTimes", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalNotice> selectByExample(PortalNoticeExample example);

    @Select({
            "select",
            "`Id`, `title`, `sub_title`, `position_id`, `position_name`, `icon`, `link`, ",
            "`begin_times`, `end_times`, `ar`, `status`, `creator_id`, `creator_name`, `create_timestamp`, ",
            "`last_update_timestamp`, `contents`",
            "from `portal_notice`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sub_title", property = "subTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "position_id", property = "positionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "position_name", property = "positionName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
            @Result(column = "begin_times", property = "beginTimes", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "end_times", property = "endTimes", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "contents", property = "contents", jdbcType = JdbcType.LONGVARBINARY)
    })
    PortalNotice selectByPrimaryKey(Long id);
}