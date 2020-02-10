package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalArticle;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalArticleExample;
import org.apache.ibatis.annotations.*;

public interface PortalArticleMapper {
    @DeleteProvider(type = PortalArticleSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalArticleExample example);

    @Delete({
            "delete from `portal_article`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_article` (`Id`, `title`, ",
            "`sub_title`, `icon`, ",
            "`link`, `ar`, `status`, ",
            "`creator_id`, `creator_name`, ",
            "`contents`)",
            "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
            "#{subTitle,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, ",
            "#{link,jdbcType=VARCHAR}, #{ar,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
            "#{creatorId,jdbcType=VARCHAR}, #{creatorName,jdbcType=VARCHAR}, ",
            "#{contents,jdbcType=LONGVARBINARY})"
    })
    int insert(PortalArticle record);

    @InsertProvider(type = PortalArticleSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalArticle record);

    @UpdateProvider(type = PortalArticleSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalArticle record, @Param("example") PortalArticleExample example);

    @UpdateProvider(type = PortalArticleSqlProvider.class, method = "updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") PortalArticle record, @Param("example") PortalArticleExample example);

    @UpdateProvider(type = PortalArticleSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalArticle record, @Param("example") PortalArticleExample example);

    @UpdateProvider(type = PortalArticleSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalArticle record);

    @Update({
            "update `portal_article`",
            "set `title` = #{title,jdbcType=VARCHAR},",
            "`sub_title` = #{subTitle,jdbcType=VARCHAR},",
            "`icon` = #{icon,jdbcType=VARCHAR},",
            "`link` = #{link,jdbcType=VARCHAR},",
            "`ar` = #{ar,jdbcType=INTEGER},",
            "`status` = #{status,jdbcType=INTEGER},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR},",
            "`contents` = #{contents,jdbcType=LONGVARBINARY}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(PortalArticle record);

    @Update({
            "update `portal_article`",
            "set `title` = #{title,jdbcType=VARCHAR},",
            "`sub_title` = #{subTitle,jdbcType=VARCHAR},",
            "`icon` = #{icon,jdbcType=VARCHAR},",
            "`link` = #{link,jdbcType=VARCHAR},",
            "`ar` = #{ar,jdbcType=INTEGER},",
            "`status` = #{status,jdbcType=INTEGER},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalArticle record);
}