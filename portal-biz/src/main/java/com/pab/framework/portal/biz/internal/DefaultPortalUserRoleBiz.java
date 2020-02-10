package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalUserRoleBiz;
import com.pab.framework.portal.models.PortalUserRoleModel;
import com.pab.framework.portal.repository.dao.PortalUserRoleDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalUserRoleBiz implements PortalUserRoleBiz {
    private static final String className = DefaultPortalUserRoleBiz.class.getName();
    @Autowired
    private PortalUserRoleDao portaluserroleDao;

    @Override
    public Long add(PortalUserRoleModel item) {
        return portaluserroleDao.add(item);
    }

    @Override
    public PortalUserRoleModel update(PortalUserRoleModel item) {
        return portaluserroleDao.update(item);
    }

    @Override
    public PortalUserRoleModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portaluserroleDao.getModelById(id);
    }

    @Override
    public List<PortalUserRoleModel> getAllList() {
        return portaluserroleDao.getAllList();
    }

    @Override
    public Pagination<PortalUserRoleModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portaluserroleDao.getPageList(pageIndex, pageSize, key), portaluserroleDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portaluserroleDao.getCount(key);
    }
}