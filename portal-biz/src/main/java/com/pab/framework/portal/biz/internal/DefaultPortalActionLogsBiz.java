package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalActionLogsBiz;
import com.pab.framework.portal.models.PortalActionLogsModel;
import com.pab.framework.portal.repository.dao.PortalActionLogsDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalActionLogsBiz implements PortalActionLogsBiz {
    private static final String className = DefaultPortalActionLogsBiz.class.getName();
    @Autowired
    private PortalActionLogsDao portalactionlogsDao;

    @Override
    public Long add(PortalActionLogsModel item) {
        return portalactionlogsDao.add(item);
    }

    @Override
    public PortalActionLogsModel update(PortalActionLogsModel item) {
        return portalactionlogsDao.update(item);
    }

    @Override
    public PortalActionLogsModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalactionlogsDao.getModelById(id);
    }

    @Override
    public List<PortalActionLogsModel> getAllList() {
        return portalactionlogsDao.getAllList();
    }

    @Override
    public Pagination<PortalActionLogsModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalactionlogsDao.getPageList(pageIndex, pageSize, key), portalactionlogsDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalactionlogsDao.getCount(key);
    }
}