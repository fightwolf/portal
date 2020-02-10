package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalUsersModel;

import java.util.List;

public interface PortalUsersDao {
    Long add(PortalUsersModel item);

    PortalUsersModel update(PortalUsersModel item);

    PortalUsersModel getModelById(Long id);

    List<PortalUsersModel> getAllList();

    List<PortalUsersModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);

    PortalUsersModel login(String username, String password);
}