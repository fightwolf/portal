package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalUserRoleOriginBuilder;

public class PortalUserRoleExtend extends PortalUserRole {

    public static PortalUserRoleExtend generateFromOriginEntity(PortalUserRole origin) {
        return PortalUserRoleOriginBuilder.buildOrigin(origin);
    }
}