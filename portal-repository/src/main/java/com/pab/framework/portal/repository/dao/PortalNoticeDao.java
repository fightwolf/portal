package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalNoticeModel;

import java.util.List;

public interface PortalNoticeDao {
    Long add(PortalNoticeModel item);

    PortalNoticeModel update(PortalNoticeModel item);

    PortalNoticeModel getModelById(Long id);

    PortalNoticeModel getModelWithBlobById(Long id);

    List<PortalNoticeModel> getAllList();

    List<PortalNoticeModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}