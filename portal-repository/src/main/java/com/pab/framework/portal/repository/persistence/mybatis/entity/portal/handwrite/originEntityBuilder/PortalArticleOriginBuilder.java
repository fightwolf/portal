package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalArticle;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.PortalArticleExtend;

public class PortalArticleOriginBuilder extends PortalArticle {

    public static PortalArticleExtend buildOrigin(PortalArticle origin) {
        if (origin == null) {
            return null;
        }
        PortalArticleExtend returnValue = new PortalArticleExtend();
        returnValue.setId(origin.getId());
        returnValue.setTitle(origin.getTitle());
        returnValue.setSubTitle(origin.getSubTitle());
        returnValue.setIcon(origin.getIcon());
        returnValue.setLink(origin.getLink());
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