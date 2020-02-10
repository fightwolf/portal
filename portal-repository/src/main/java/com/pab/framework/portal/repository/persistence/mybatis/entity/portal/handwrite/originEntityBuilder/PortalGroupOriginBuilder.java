package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalGroupExtend;

public class PortalGroupOriginBuilder extends PortalGroup {

    public static PortalGroupExtend buildOrigin(PortalGroup origin) {
        if (origin == null) {
            return null;
        }
        PortalGroupExtend returnValue = new PortalGroupExtend();
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