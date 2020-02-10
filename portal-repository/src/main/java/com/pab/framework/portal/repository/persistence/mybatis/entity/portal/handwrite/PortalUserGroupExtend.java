package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalUserGroupOriginBuilder;

public class PortalUserGroupExtend extends PortalUserGroup {

    public static PortalUserGroupExtend generateFromOriginEntity(PortalUserGroup origin) {
        return PortalUserGroupOriginBuilder.buildOrigin(origin);
    }
}