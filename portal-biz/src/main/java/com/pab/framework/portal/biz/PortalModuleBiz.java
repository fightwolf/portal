package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalModuleModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalModuleBiz {
    Long add(PortalModuleModel item);

    PortalModuleModel update(PortalModuleModel item);

    PortalModuleModel getModelById(Long id);

    List<PortalModuleModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}