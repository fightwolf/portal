package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalRoleGroupModel;

import java.util.List;

public interface PortalRoleGroupDao {
    Long add(PortalRoleGroupModel item);

    PortalRoleGroupModel update(PortalRoleGroupModel item);

    PortalRoleGroupModel getModelById(Long id);

    List<PortalRoleGroupModel> getAllList();

    List<PortalRoleGroupModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}