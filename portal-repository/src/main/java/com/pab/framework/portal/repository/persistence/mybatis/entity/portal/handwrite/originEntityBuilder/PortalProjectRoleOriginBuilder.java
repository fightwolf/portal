package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalProjectRoleExtend;

public class PortalProjectRoleOriginBuilder extends PortalProjectRole {

    public static PortalProjectRoleExtend buildOrigin(PortalProjectRole origin) {
        if (origin == null) {
            return null;
        }
        PortalProjectRoleExtend returnValue = new PortalProjectRoleExtend();
        returnValue.setId(origin.getId());
        returnValue.setRoleCode(origin.getRoleCode());
        returnValue.setProjectCode(origin.getProjectCode());
        returnValue.setCreatorId(origin.getCreatorId());
        returnValue.setCreatorName(origin.getCreatorName());
        returnValue.setCreateTimestamp(origin.getCreateTimestamp());
        returnValue.setLastUpdateTimestamp(origin.getLastUpdateTimestamp());
        return returnValue;
    }
}