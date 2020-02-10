package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalModuleBiz;
import com.pab.framework.portal.models.PortalModuleModel;
import com.pab.framework.portal.repository.dao.PortalModuleDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalModuleBiz implements PortalModuleBiz {
    private static final String className = DefaultPortalModuleBiz.class.getName();
    @Autowired
    private PortalModuleDao portalmoduleDao;

    @Override
    public Long add(PortalModuleModel item) {
        return portalmoduleDao.add(item);
    }

    @Override
    public PortalModuleModel update(PortalModuleModel item) {
        return portalmoduleDao.update(item);
    }

    @Override
    public PortalModuleModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalmoduleDao.getModelById(id);
    }

    @Override
    public List<PortalModuleModel> getAllList() {
        return portalmoduleDao.getAllList();
    }

    @Override
    public Pagination<PortalModuleModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalmoduleDao.getPageList(pageIndex, pageSize, key), portalmoduleDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalmoduleDao.getCount(key);
    }
}