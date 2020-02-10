package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalGroupOriginBuilder;

public class PortalGroupExtend extends PortalGroup {

    public static PortalGroupExtend generateFromOriginEntity(PortalGroup origin) {
        return PortalGroupOriginBuilder.buildOrigin(origin);
    }
}