package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalArticle;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalArticleExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalArticleMapper {
    @SelectProvider(type = PortalArticleSqlProvider.class, method = "countByExample")
    int countByExample(PortalArticleExample example);

    @SelectProvider(type = PortalArticleSqlProvider.class, method = "selectByExampleWithBLOBs")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sub_title", property = "subTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "contents", property = "contents", jdbcType = JdbcType.LONGVARBINARY)
    })
    List<PortalArticle> selectByExampleWithBLOBs(PortalArticleExample example);

    @SelectProvider(type = PortalArticleSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sub_title", property = "subTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalArticle> selectByExample(PortalArticleExample example);

    @Select({
            "select",
            "`Id`, `title`, `sub_title`, `icon`, `link`, `ar`, `status`, `creator_id`, `creator_name`, ",
            "`create_timestamp`, `last_update_timestamp`, `contents`",
            "from `portal_article`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sub_title", property = "subTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "contents", property = "contents", jdbcType = JdbcType.LONGVARBINARY)
    })
    PortalArticle selectByPrimaryKey(Long id);
}