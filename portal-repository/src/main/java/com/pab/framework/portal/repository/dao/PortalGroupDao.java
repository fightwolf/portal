package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalGroupModel;

import java.util.List;

public interface PortalGroupDao {
    Long add(PortalGroupModel item);

    PortalGroupModel update(PortalGroupModel item);

    PortalGroupModel getModelById(Long id);

    List<PortalGroupModel> getAllList();

    List<PortalGroupModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}