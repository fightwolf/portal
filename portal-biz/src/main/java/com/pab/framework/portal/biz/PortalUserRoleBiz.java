package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalUserRoleModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalUserRoleBiz {
    Long add(PortalUserRoleModel item);

    PortalUserRoleModel update(PortalUserRoleModel item);

    PortalUserRoleModel getModelById(Long id);

    List<PortalUserRoleModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}