package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalModule;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalModuleOriginBuilder;

public class PortalModuleExtend extends PortalModule {

    public static PortalModuleExtend generateFromOriginEntity(PortalModule origin) {
        return PortalModuleOriginBuilder.buildOrigin(origin);
    }
}