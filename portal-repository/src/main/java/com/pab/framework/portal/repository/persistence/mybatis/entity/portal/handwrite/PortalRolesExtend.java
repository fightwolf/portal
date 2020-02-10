package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoles;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalRolesOriginBuilder;

public class PortalRolesExtend extends PortalRoles {

    public static PortalRolesExtend generateFromOriginEntity(PortalRoles origin) {
        return PortalRolesOriginBuilder.buildOrigin(origin);
    }
}