package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalUserGroupExtend;

public class PortalUserGroupOriginBuilder extends PortalUserGroup {

    public static PortalUserGroupExtend buildOrigin(PortalUserGroup origin) {
        if (origin == null) {
            return null;
        }
        PortalUserGroupExtend returnValue = new PortalUserGroupExtend();
        returnValue.setId(origin.getId());
        returnValue.setUserCode(origin.getUserCode());
        returnValue.setRoleCode(origin.getRoleCode());
        returnValue.setCreatorId(origin.getCreatorId());
        returnValue.setCreatorName(origin.getCreatorName());
        returnValue.setCreateTimestamp(origin.getCreateTimestamp());
        returnValue.setLastUpdateTimestamp(origin.getLastUpdateTimestamp());
        return returnValue;
    }
}