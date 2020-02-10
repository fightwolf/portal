package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalUserRoleModel;

import java.util.List;

public interface PortalUserRoleDao {
    Long add(PortalUserRoleModel item);

    PortalUserRoleModel update(PortalUserRoleModel item);

    PortalUserRoleModel getModelById(Long id);

    List<PortalUserRoleModel> getAllList();

    List<PortalUserRoleModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}