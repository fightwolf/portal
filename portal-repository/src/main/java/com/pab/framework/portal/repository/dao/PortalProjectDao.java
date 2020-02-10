package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalProjectModel;

import java.util.List;

public interface PortalProjectDao {
    Long add(PortalProjectModel item);

    PortalProjectModel update(PortalProjectModel item);

    PortalProjectModel getModelById(Long id);

    List<PortalProjectModel> getAllList();

    List<PortalProjectModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}