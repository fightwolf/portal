package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoles;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalRolesExtend;

public class PortalRolesOriginBuilder extends PortalRoles {

    public static PortalRolesExtend buildOrigin(PortalRoles origin) {
        if (origin == null) {
            return null;
        }
        PortalRolesExtend returnValue = new PortalRolesExtend();
        returnValue.setId(origin.getId());
        returnValue.setRoleCode(origin.getRoleCode());
        returnValue.setRoleName(origin.getRoleName());
        returnValue.setAr(origin.getAr());
        returnValue.setDescribes(origin.getDescribes());
        returnValue.setStatus(origin.getStatus());
        returnValue.setCreatorId(origin.getCreatorId());
        returnValue.setCreatorName(origin.getCreatorName());
        returnValue.setCreateTimestamp(origin.getCreateTimestamp());
        returnValue.setLastUpdateTimestamp(origin.getLastUpdateTimestamp());
        return returnValue;
    }
}