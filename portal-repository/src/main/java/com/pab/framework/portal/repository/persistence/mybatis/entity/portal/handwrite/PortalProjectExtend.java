package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProject;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalProjectOriginBuilder;

public class PortalProjectExtend extends PortalProject {

    public static PortalProjectExtend generateFromOriginEntity(PortalProject origin) {
        return PortalProjectOriginBuilder.buildOrigin(origin);
    }
}