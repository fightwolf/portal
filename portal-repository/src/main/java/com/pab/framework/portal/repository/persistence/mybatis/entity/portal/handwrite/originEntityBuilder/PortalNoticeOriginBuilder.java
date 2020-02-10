package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNotice;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalNoticeExtend;

public class PortalNoticeOriginBuilder extends PortalNotice {

    public static PortalNoticeExtend buildOrigin(PortalNotice origin) {
        if (origin == null) {
            return null;
        }
        PortalNoticeExtend returnValue = new PortalNoticeExtend();
        returnValue.setId(origin.getId());
        returnValue.setTitle(origin.getTitle());
        returnValue.setSubTitle(origin.getSubTitle());
        returnValue.setPositionId(origin.getPositionId());
        returnValue.setPositionName(origin.getPositionName());
        returnValue.setIcon(origin.getIcon());
        returnValue.setLink(origin.getLink());
        returnValue.setBeginTimes(origin.getBeginTimes());
        returnValue.setEndTimes(origin.getEndTimes());
        returnValue.setAr(origin.getAr());
        returnValue.setStatus(origin.getStatus());
        returnValue.setCreatorId(origin.getCreatorId());
        returnValue.setCreatorName(origin.getCreatorName());
        returnValue.setContents(origin.getContents());
        returnValue.setCreateTimestamp(origin.getCreateTimestamp());
        returnValue.setLastUpdateTimestamp(origin.getLastUpdateTimestamp());
        return returnValue;
    }
}