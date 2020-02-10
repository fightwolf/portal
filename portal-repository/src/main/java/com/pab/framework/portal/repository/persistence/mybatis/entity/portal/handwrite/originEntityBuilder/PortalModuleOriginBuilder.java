package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalModule;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalModuleExtend;

public class PortalModuleOriginBuilder extends PortalModule {

    public static PortalModuleExtend buildOrigin(PortalModule origin) {
        if (origin == null) {
            return null;
        }
        PortalModuleExtend returnValue = new PortalModuleExtend();
        returnValue.setId(origin.getId());
        returnValue.setModuleName(origin.getModuleName());
        returnValue.setModuleCode(origin.getModuleCode());
        returnValue.setParentCode(origin.getParentCode());
        returnValue.setIcon(origin.getIcon());
        returnValue.setLink(origin.getLink());
        returnValue.setDescribes(origin.getDescribes());
        returnValue.setAr(origin.getAr());
        returnValue.setStatus(origin.getStatus());
        returnValue.setCreatorId(origin.getCreatorId());
        returnValue.setCreatorName(origin.getCreatorName());
        returnValue.setCreateTimestamp(origin.getCreateTimestamp());
        returnValue.setLastUpdateTimestamp(origin.getLastUpdateTimestamp());
        return returnValue;
    }
}