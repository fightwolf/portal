package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalActionLogs;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalActionLogsOriginBuilder;

public class PortalActionLogsExtend extends PortalActionLogs {

    public static PortalActionLogsExtend generateFromOriginEntity(PortalActionLogs origin) {
        return PortalActionLogsOriginBuilder.buildOrigin(origin);
    }
}