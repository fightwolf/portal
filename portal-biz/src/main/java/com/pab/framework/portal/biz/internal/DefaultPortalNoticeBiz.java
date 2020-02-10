package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalNoticeBiz;
import com.pab.framework.portal.models.PortalNoticeModel;
import com.pab.framework.portal.repository.dao.PortalNoticeDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalNoticeBiz implements PortalNoticeBiz {
    private static final String className = DefaultPortalNoticeBiz.class.getName();
    @Autowired
    private PortalNoticeDao portalnoticeDao;

    @Override
    public Long add(PortalNoticeModel item) {
        return portalnoticeDao.add(item);
    }

    @Override
    public PortalNoticeModel update(PortalNoticeModel item) {
        return portalnoticeDao.update(item);
    }

    @Override
    public PortalNoticeModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalnoticeDao.getModelById(id);
    }

    @Override
    public PortalNoticeModel getModelWithBlobById(Long id) {
        if (id == null) {
            return null;
        }
        return portalnoticeDao.getModelWithBlobById(id);
    }

    @Override
    public List<PortalNoticeModel> getAllList() {
        return portalnoticeDao.getAllList();
    }

    @Override
    public Pagination<PortalNoticeModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalnoticeDao.getPageList(pageIndex, pageSize, key), portalnoticeDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalnoticeDao.getCount(key);
    }
}