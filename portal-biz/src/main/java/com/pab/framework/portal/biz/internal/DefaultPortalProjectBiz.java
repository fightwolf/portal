package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalProjectBiz;
import com.pab.framework.portal.models.PortalProjectModel;
import com.pab.framework.portal.repository.dao.PortalProjectDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalProjectBiz implements PortalProjectBiz {
    private static final String className = DefaultPortalProjectBiz.class.getName();
    @Autowired
    private PortalProjectDao portalprojectDao;

    @Override
    public Long add(PortalProjectModel item) {
        return portalprojectDao.add(item);
    }

    @Override
    public PortalProjectModel update(PortalProjectModel item) {
        return portalprojectDao.update(item);
    }

    @Override
    public PortalProjectModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalprojectDao.getModelById(id);
    }

    @Override
    public List<PortalProjectModel> getAllList() {
        return portalprojectDao.getAllList();
    }

    @Override
    public Pagination<PortalProjectModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalprojectDao.getPageList(pageIndex, pageSize, key), portalprojectDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalprojectDao.getCount(key);
    }
}