package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUsers;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUsersExample;
import org.apache.ibatis.annotations.*;

public interface PortalUsersMapper {
    @DeleteProvider(type = PortalUsersSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PortalUsersExample example);

    @Delete({
            "delete from `portal_users`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into `portal_users` (`Id`, `user_code`, ",
            "`user_name`, `user_pwd`, ",
            "`user_type`, `user_email`, ",
            "`user_phone`, `avatar`, ",
            "`registe_ip`, `creator_id`, ",
            "`creator_name`)",
            "values (#{id,jdbcType=BIGINT}, #{userCode,jdbcType=VARCHAR}, ",
            "#{userName,jdbcType=VARCHAR}, #{userPwd,jdbcType=VARCHAR}, ",
            "#{userType,jdbcType=VARCHAR}, #{userEmail,jdbcType=VARCHAR}, ",
            "#{userPhone,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, ",
            "#{registeIp,jdbcType=VARCHAR}, #{creatorId,jdbcType=VARCHAR}, ",
            "#{creatorName,jdbcType=VARCHAR})"
    })
    int insert(PortalUsers record);

    @InsertProvider(type = PortalUsersSqlProvider.class, method = "insertSelective")
    int insertSelective(PortalUsers record);

    @UpdateProvider(type = PortalUsersSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortalUsers record, @Param("example") PortalUsersExample example);

    @UpdateProvider(type = PortalUsersSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PortalUsers record, @Param("example") PortalUsersExample example);

    @UpdateProvider(type = PortalUsersSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortalUsers record);

    @Update({
            "update `portal_users`",
            "set `user_code` = #{userCode,jdbcType=VARCHAR},",
            "`user_name` = #{userName,jdbcType=VARCHAR},",
            "`user_pwd` = #{userPwd,jdbcType=VARCHAR},",
            "`user_type` = #{userType,jdbcType=VARCHAR},",
            "`user_email` = #{userEmail,jdbcType=VARCHAR},",
            "`user_phone` = #{userPhone,jdbcType=VARCHAR},",
            "`avatar` = #{avatar,jdbcType=VARCHAR},",
            "`registe_ip` = #{registeIp,jdbcType=VARCHAR},",
            "`creator_id` = #{creatorId,jdbcType=VARCHAR},",
            "`creator_name` = #{creatorName,jdbcType=VARCHAR}",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PortalUsers record);
}