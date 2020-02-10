package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalProjectRoleModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalProjectRoleBiz {
    Long add(PortalProjectRoleModel item);

    PortalProjectRoleModel update(PortalProjectRoleModel item);

    PortalProjectRoleModel getModelById(Long id);

    List<PortalProjectRoleModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}