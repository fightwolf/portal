package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalNoticeModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalNoticeBiz {
    Long add(PortalNoticeModel item);

    PortalNoticeModel update(PortalNoticeModel item);

    PortalNoticeModel getModelById(Long id);

    PortalNoticeModel getModelWithBlobById(Long id);

    List<PortalNoticeModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}