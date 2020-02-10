package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoleGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalRoleGroupExtend;

public class PortalRoleGroupOriginBuilder extends PortalRoleGroup {

    public static PortalRoleGroupExtend buildOrigin(PortalRoleGroup origin) {
        if (origin == null) {
            return null;
        }
        PortalRoleGroupExtend returnValue = new PortalRoleGroupExtend();
        returnValue.setId(origin.getId());
        returnValue.setGroupCode(origin.getGroupCode());
        returnValue.setRoleCode(origin.getRoleCode());
        returnValue.setCreatorId(origin.getCreatorId());
        returnValue.setCreatorName(origin.getCreatorName());
        returnValue.setCreateTimestamp(origin.getCreateTimestamp());
        returnValue.setLastUpdateTimestamp(origin.getLastUpdateTimestamp());
        return returnValue;
    }
}