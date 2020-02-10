package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalUserGroupModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalUserGroupBiz {
    Long add(PortalUserGroupModel item);

    PortalUserGroupModel update(PortalUserGroupModel item);

    PortalUserGroupModel getModelById(Long id);

    List<PortalUserGroupModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}