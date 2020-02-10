package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalRoleGroupBiz;
import com.pab.framework.portal.models.PortalRoleGroupModel;
import com.pab.framework.portal.repository.dao.PortalRoleGroupDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalRoleGroupBiz implements PortalRoleGroupBiz {
    private static final String className = DefaultPortalRoleGroupBiz.class.getName();
    @Autowired
    private PortalRoleGroupDao portalrolegroupDao;

    @Override
    public Long add(PortalRoleGroupModel item) {
        return portalrolegroupDao.add(item);
    }

    @Override
    public PortalRoleGroupModel update(PortalRoleGroupModel item) {
        return portalrolegroupDao.update(item);
    }

    @Override
    public PortalRoleGroupModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalrolegroupDao.getModelById(id);
    }

    @Override
    public List<PortalRoleGroupModel> getAllList() {
        return portalrolegroupDao.getAllList();
    }

    @Override
    public Pagination<PortalRoleGroupModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalrolegroupDao.getPageList(pageIndex, pageSize, key), portalrolegroupDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalrolegroupDao.getCount(key);
    }
}