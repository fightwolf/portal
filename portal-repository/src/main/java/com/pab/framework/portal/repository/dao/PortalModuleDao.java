package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalModuleModel;

import java.util.List;

public interface PortalModuleDao {
    Long add(PortalModuleModel item);

    PortalModuleModel update(PortalModuleModel item);

    PortalModuleModel getModelById(Long id);

    List<PortalModuleModel> getAllList();

    List<PortalModuleModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}