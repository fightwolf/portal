package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalProjectModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalProjectBiz {
    Long add(PortalProjectModel item);

    PortalProjectModel update(PortalProjectModel item);

    PortalProjectModel getModelById(Long id);

    List<PortalProjectModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}