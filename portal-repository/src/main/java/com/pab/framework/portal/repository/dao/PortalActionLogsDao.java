package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalActionLogsModel;

import java.util.List;

public interface PortalActionLogsDao {
    Long add(PortalActionLogsModel item);

    PortalActionLogsModel update(PortalActionLogsModel item);

    PortalActionLogsModel getModelById(Long id);

    List<PortalActionLogsModel> getAllList();

    List<PortalActionLogsModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}