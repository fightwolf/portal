package com.pab.framework.portal.biz;

import com.pab.framework.portal.models.PortalArticleModel;
import com.pab.framework.portal.utils.mybatis.Pagination;

import java.util.List;

public interface PortalArticleBiz {
    Long add(PortalArticleModel item);

    PortalArticleModel update(PortalArticleModel item);

    PortalArticleModel getModelById(Long id);

    PortalArticleModel getModelWithBlobById(Long id);

    List<PortalArticleModel> getAllList();

    Pagination getPageList(int pageIndex, int pageSize, String key);

    int getCount(String key);
}