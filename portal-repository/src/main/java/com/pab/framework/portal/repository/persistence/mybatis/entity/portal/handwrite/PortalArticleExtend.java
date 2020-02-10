package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalArticle;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalArticleOriginBuilder;

public class PortalArticleExtend extends PortalArticle {

    public static PortalArticleExtend generateFromOriginEntity(PortalArticle origin) {
        return PortalArticleOriginBuilder.buildOrigin(origin);
    }
}