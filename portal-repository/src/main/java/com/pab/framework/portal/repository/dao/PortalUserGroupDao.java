package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalUserGroupModel;

import java.util.List;

public interface PortalUserGroupDao {
    Long add(PortalUserGroupModel item);

    PortalUserGroupModel update(PortalUserGroupModel item);

    PortalUserGroupModel getModelById(Long id);

    List<PortalUserGroupModel> getAllList();

    List<PortalUserGroupModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}