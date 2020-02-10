package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalUsersBiz;
import com.pab.framework.portal.models.PortalUsersModel;
import com.pab.framework.portal.repository.dao.PortalUsersDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalUsersBiz implements PortalUsersBiz {
    private static final String className = DefaultPortalUsersBiz.class.getName();
    @Autowired
    private PortalUsersDao portalusersDao;

    @Override
    public Long add(PortalUsersModel item) {
        return portalusersDao.add(item);
    }

    @Override
    public PortalUsersModel update(PortalUsersModel item) {
        return portalusersDao.update(item);
    }

    @Override
    public PortalUsersModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalusersDao.getModelById(id);
    }

    @Override
    public List<PortalUsersModel> getAllList() {
        return portalusersDao.getAllList();
    }

    @Override
    public Pagination<PortalUsersModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalusersDao.getPageList(pageIndex, pageSize, key), portalusersDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalusersDao.getCount(key);
    }

    @Override
    public PortalUsersModel login(String username, String password) {
        return portalusersDao.login(username ,password);
    }
}