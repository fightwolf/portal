package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalGroupBiz;
import com.pab.framework.portal.models.PortalGroupModel;
import com.pab.framework.portal.repository.dao.PortalGroupDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalGroupBiz implements PortalGroupBiz {
    private static final String className = DefaultPortalGroupBiz.class.getName();
    @Autowired
    private PortalGroupDao portalgroupDao;

    @Override
    public Long add(PortalGroupModel item) {
        return portalgroupDao.add(item);
    }

    @Override
    public PortalGroupModel update(PortalGroupModel item) {
        return portalgroupDao.update(item);
    }

    @Override
    public PortalGroupModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalgroupDao.getModelById(id);
    }

    @Override
    public List<PortalGroupModel> getAllList() {
        return portalgroupDao.getAllList();
    }

    @Override
    public Pagination<PortalGroupModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalgroupDao.getPageList(pageIndex, pageSize, key), portalgroupDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalgroupDao.getCount(key);
    }
}