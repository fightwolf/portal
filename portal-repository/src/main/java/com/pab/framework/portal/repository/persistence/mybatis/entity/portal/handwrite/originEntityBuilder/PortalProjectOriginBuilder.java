package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProject;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalProjectExtend;

public class PortalProjectOriginBuilder extends PortalProject {

    public static PortalProjectExtend buildOrigin(PortalProject origin) {
        if (origin == null) {
            return null;
        }
        PortalProjectExtend returnValue = new PortalProjectExtend();
        returnValue.setId(origin.getId());
        returnValue.setProjectCode(origin.getProjectCode());
        returnValue.setProjectName(origin.getProjectName());
        returnValue.setProjectType(origin.getProjectType());
        returnValue.setParentCode(origin.getParentCode());
        returnValue.setUrl(origin.getUrl());
        returnValue.setUrlName(origin.getUrlName());
        returnValue.setDescribes(origin.getDescribes());
        returnValue.setCreatorId(origin.getCreatorId());
        returnValue.setCreatorName(origin.getCreatorName());
        returnValue.setCreateTimestamp(origin.getCreateTimestamp());
        returnValue.setLastUpdateTimestamp(origin.getLastUpdateTimestamp());
        return returnValue;
    }
}