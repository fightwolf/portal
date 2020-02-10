package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalUserGroupBiz;
import com.pab.framework.portal.models.PortalUserGroupModel;
import com.pab.framework.portal.repository.dao.PortalUserGroupDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalUserGroupBiz implements PortalUserGroupBiz {
    private static final String className = DefaultPortalUserGroupBiz.class.getName();
    @Autowired
    private PortalUserGroupDao portalusergroupDao;

    @Override
    public Long add(PortalUserGroupModel item) {
        return portalusergroupDao.add(item);
    }

    @Override
    public PortalUserGroupModel update(PortalUserGroupModel item) {
        return portalusergroupDao.update(item);
    }

    @Override
    public PortalUserGroupModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalusergroupDao.getModelById(id);
    }

    @Override
    public List<PortalUserGroupModel> getAllList() {
        return portalusergroupDao.getAllList();
    }

    @Override
    public Pagination<PortalUserGroupModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalusergroupDao.getPageList(pageIndex, pageSize, key), portalusergroupDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalusergroupDao.getCount(key);
    }
}