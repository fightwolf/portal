package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUsers;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalUsersExtend;

public class PortalUsersOriginBuilder extends PortalUsers {

    public static PortalUsersExtend buildOrigin(PortalUsers origin) {
        if (origin == null) {
            return null;
        }
        PortalUsersExtend returnValue = new PortalUsersExtend();
        returnValue.setId(origin.getId());
        returnValue.setUserCode(origin.getUserCode());
        returnValue.setUserName(origin.getUserName());
        returnValue.setUserPwd(origin.getUserPwd());
        returnValue.setUserType(origin.getUserType());
        returnValue.setUserEmail(origin.getUserEmail());
        returnValue.setUserPhone(origin.getUserPhone());
        returnValue.setAvatar(origin.getAvatar());
        returnValue.setRegisteIp(origin.getRegisteIp());
        returnValue.setCreatorId(origin.getCreatorId());
        returnValue.setCreatorName(origin.getCreatorName());
        returnValue.setCreateTimestamp(origin.getCreateTimestamp());
        returnValue.setLastUpdateTimestamp(origin.getLastUpdateTimestamp());
        return returnValue;
    }
}