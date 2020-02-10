package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalProjectRoleBiz;
import com.pab.framework.portal.models.PortalProjectRoleModel;
import com.pab.framework.portal.repository.dao.PortalProjectRoleDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalProjectRoleBiz implements PortalProjectRoleBiz {
    private static final String className = DefaultPortalProjectRoleBiz.class.getName();
    @Autowired
    private PortalProjectRoleDao portalprojectroleDao;

    @Override
    public Long add(PortalProjectRoleModel item) {
        return portalprojectroleDao.add(item);
    }

    @Override
    public PortalProjectRoleModel update(PortalProjectRoleModel item) {
        return portalprojectroleDao.update(item);
    }

    @Override
    public PortalProjectRoleModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalprojectroleDao.getModelById(id);
    }

    @Override
    public List<PortalProjectRoleModel> getAllList() {
        return portalprojectroleDao.getAllList();
    }

    @Override
    public Pagination<PortalProjectRoleModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalprojectroleDao.getPageList(pageIndex, pageSize, key), portalprojectroleDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalprojectroleDao.getCount(key);
    }
}