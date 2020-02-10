package com.pab.framework.portal.repository.dao;

import com.pab.framework.portal.models.PortalArticleModel;

import java.util.List;

public interface PortalArticleDao {
    Long add(PortalArticleModel item);

    PortalArticleModel update(PortalArticleModel item);

    PortalArticleModel getModelById(Long id);

    PortalArticleModel getModelWithBlobById(Long id);

    List<PortalArticleModel> getAllList();

    List<PortalArticleModel> getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}