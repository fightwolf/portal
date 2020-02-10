package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalProjectRoleModel;

import java.util.List;

public interface PortalProjectRoleDao {
    Long add(PortalProjectRoleModel item);

    PortalProjectRoleModel update(PortalProjectRoleModel item);

    PortalProjectRoleModel getModelById(Long id);

    List<PortalProjectRoleModel> getAllList();

    List<PortalProjectRoleModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}