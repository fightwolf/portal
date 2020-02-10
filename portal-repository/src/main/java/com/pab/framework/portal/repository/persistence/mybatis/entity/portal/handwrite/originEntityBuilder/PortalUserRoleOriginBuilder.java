package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalUserRoleExtend;

public class PortalUserRoleOriginBuilder extends PortalUserRole {

    public static PortalUserRoleExtend buildOrigin(PortalUserRole origin) {
        if (origin == null) {
            return null;
        }
        PortalUserRoleExtend returnValue = new PortalUserRoleExtend();
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