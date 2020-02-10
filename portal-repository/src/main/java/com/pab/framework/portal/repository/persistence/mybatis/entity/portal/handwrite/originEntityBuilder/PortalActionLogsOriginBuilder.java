package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalActionLogs;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalActionLogsExtend;

public class PortalActionLogsOriginBuilder extends PortalActionLogs {

    public static PortalActionLogsExtend buildOrigin(PortalActionLogs origin) {
        if (origin == null) {
            return null;
        }
        PortalActionLogsExtend returnValue = new PortalActionLogsExtend();
        returnValue.setId(origin.getId());
        returnValue.setOperationType(origin.getOperationType());
        returnValue.setOperationName(origin.getOperationName());
        returnValue.setParentCode(origin.getParentCode());
        returnValue.setDescribes(origin.getDescribes());
        returnValue.setIp(origin.getIp());
        returnValue.setCreatorId(origin.getCreatorId());
        returnValue.setCreatorName(origin.getCreatorName());
        returnValue.setCreateTimestamp(origin.getCreateTimestamp());
        returnValue.setLastUpdateTimestamp(origin.getLastUpdateTimestamp());
        return returnValue;
    }
}