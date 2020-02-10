package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalRolesModel;

import java.util.List;

public interface PortalRolesDao {
    Long add(PortalRolesModel item);

    PortalRolesModel update(PortalRolesModel item);

    PortalRolesModel getModelById(Long id);

    List<PortalRolesModel> getAllList();

    List<PortalRolesModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}