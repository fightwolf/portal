package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalRolesModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalRolesBiz {
    Long add(PortalRolesModel item);

    PortalRolesModel update(PortalRolesModel item);

    PortalRolesModel getModelById(Long id);

    List<PortalRolesModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}