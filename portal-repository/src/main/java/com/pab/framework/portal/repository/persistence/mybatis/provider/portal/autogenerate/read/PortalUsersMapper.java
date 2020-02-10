package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUsers;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUsersExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PortalUsersMapper {
    @SelectProvider(type = PortalUsersSqlProvider.class, method = "countByExample")
    int countByExample(PortalUsersExample example);

    @SelectProvider(type = PortalUsersSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_code", property = "userCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_pwd", property = "userPwd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_type", property = "userType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_email", property = "userEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "avatar", property = "avatar", jdbcType = JdbcType.VARCHAR),
            @Result(column = "registe_ip", property = "registeIp", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PortalUsers> selectByExample(PortalUsersExample example);

    @Select({
            "select",
            "`Id`, `user_code`, `user_name`, `user_pwd`, `user_type`, `user_email`, `user_phone`, ",
            "`avatar`, `registe_ip`, `creator_id`, `creator_name`, `create_timestamp`, `last_update_timestamp`",
            "from `portal_users`",
            "where `Id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "Id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_code", property = "userCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_pwd", property = "userPwd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_type", property = "userType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_email", property = "userEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "avatar", property = "avatar", jdbcType = JdbcType.VARCHAR),
            @Result(column = "registe_ip", property = "registeIp", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_name", property = "creatorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_timestamp", property = "lastUpdateTimestamp", jdbcType = JdbcType.TIMESTAMP)
    })
    PortalUsers selectByPrimaryKey(Long id);
}