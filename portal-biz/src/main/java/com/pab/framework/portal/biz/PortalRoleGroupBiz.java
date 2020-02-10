package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalRoleGroupModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalRoleGroupBiz {
    Long add(PortalRoleGroupModel item);

    PortalRoleGroupModel update(PortalRoleGroupModel item);

    PortalRoleGroupModel getModelById(Long id);

    List<PortalRoleGroupModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}