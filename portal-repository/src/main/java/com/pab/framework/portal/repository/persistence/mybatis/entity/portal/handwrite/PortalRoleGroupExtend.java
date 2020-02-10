package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoleGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalRoleGroupOriginBuilder;

public class PortalRoleGroupExtend extends PortalRoleGroup {

    public static PortalRoleGroupExtend generateFromOriginEntity(PortalRoleGroup origin) {
        return PortalRoleGroupOriginBuilder.buildOrigin(origin);
    }
}