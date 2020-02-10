package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalRolesBiz;
import com.pab.framework.portal.models.PortalRolesModel;
import com.pab.framework.portal.repository.dao.PortalRolesDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalRolesBiz implements PortalRolesBiz {
    private static final String className = DefaultPortalRolesBiz.class.getName();
    @Autowired
    private PortalRolesDao portalrolesDao;

    @Override
    public Long add(PortalRolesModel item) {
        return portalrolesDao.add(item);
    }

    @Override
    public PortalRolesModel update(PortalRolesModel item) {
        return portalrolesDao.update(item);
    }

    @Override
    public PortalRolesModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalrolesDao.getModelById(id);
    }

    @Override
    public List<PortalRolesModel> getAllList() {
        return portalrolesDao.getAllList();
    }

    @Override
    public Pagination<PortalRolesModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalrolesDao.getPageList(pageIndex, pageSize, key), portalrolesDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalrolesDao.getCount(key);
    }
}