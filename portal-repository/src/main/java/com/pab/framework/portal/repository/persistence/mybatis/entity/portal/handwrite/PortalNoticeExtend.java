package com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNotice;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.handwrite.originEntityBuilder.PortalNoticeOriginBuilder;

public class PortalNoticeExtend extends PortalNotice {

    public static PortalNoticeExtend generateFromOriginEntity(PortalNotice origin) {
        return PortalNoticeOriginBuilder.buildOrigin(origin);
    }
}