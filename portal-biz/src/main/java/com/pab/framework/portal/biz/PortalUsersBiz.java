package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalUsersModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalUsersBiz {
    Long add(PortalUsersModel item);

    PortalUsersModel update(PortalUsersModel item);

    PortalUsersModel getModelById(Long id);

    List<PortalUsersModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);

    PortalUsersModel login(String username, String md5);
}