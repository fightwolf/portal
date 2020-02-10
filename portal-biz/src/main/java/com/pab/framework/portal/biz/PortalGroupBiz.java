package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalGroupModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalGroupBiz {
    Long add(PortalGroupModel item);

    PortalGroupModel update(PortalGroupModel item);

    PortalGroupModel getModelById(Long id);

    List<PortalGroupModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}