package com.pab.framework.portal.biz.internal;

import com.pab.framework.portal.biz.PortalArticleBiz;
import com.pab.framework.portal.models.PortalArticleModel;
import com.pab.framework.portal.repository.dao.PortalArticleDao;
import com.pab.framework.portal.utils.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPortalArticleBiz implements PortalArticleBiz {
    private static final String className = DefaultPortalArticleBiz.class.getName();
    @Autowired
    private PortalArticleDao portalarticleDao;

    @Override
    public Long add(PortalArticleModel item) {
        return portalarticleDao.add(item);
    }

    @Override
    public PortalArticleModel update(PortalArticleModel item) {
        return portalarticleDao.update(item);
    }

    @Override
    public PortalArticleModel getModelById(Long id) {
        if (id == null) {
            return null;
        }
        return portalarticleDao.getModelById(id);
    }

    @Override
    public PortalArticleModel getModelWithBlobById(Long id) {
        if (id == null) {
            return null;
        }
        return portalarticleDao.getModelWithBlobById(id);
    }

    @Override
    public List<PortalArticleModel> getAllList() {
        return portalarticleDao.getAllList();
    }

    @Override
    public Pagination<PortalArticleModel> getPageList(int pageIndex, int pageSize, String key) {
        return new Pagination(pageIndex, pageSize, portalarticleDao.getPageList(pageIndex, pageSize, key), portalarticleDao.getCount(key));
    }

    @Override
    public int getCount(String key) {
        return portalarticleDao.getCount(key);
    }
}