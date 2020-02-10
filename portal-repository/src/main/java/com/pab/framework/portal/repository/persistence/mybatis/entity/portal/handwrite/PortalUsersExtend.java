package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUsers;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalUsersOriginBuilder;

public class PortalUsersExtend extends PortalUsers {

    public static PortalUsersExtend generateFromOriginEntity(PortalUsers origin) {
        return PortalUsersOriginBuilder.buildOrigin(origin);
    }
}