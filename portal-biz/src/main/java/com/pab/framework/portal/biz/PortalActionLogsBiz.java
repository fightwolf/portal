package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalActionLogsModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalActionLogsBiz {
    Long add(PortalActionLogsModel item);

    PortalActionLogsModel update(PortalActionLogsModel item);

    PortalActionLogsModel getModelById(Long id);

    List<PortalActionLogsModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}