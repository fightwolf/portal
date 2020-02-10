package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalProjectRoleOriginBuilder;

public class PortalProjectRoleExtend extends PortalProjectRole {

    public static PortalProjectRoleExtend generateFromOriginEntity(PortalProjectRole origin) {
        return PortalProjectRoleOriginBuilder.buildOrigin(origin);
    }
}