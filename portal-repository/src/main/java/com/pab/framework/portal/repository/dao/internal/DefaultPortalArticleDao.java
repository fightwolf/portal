package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalArticleModel;
import com.pab.framework.portal.repository.dao.PortalArticleDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalArticle;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalArticleExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalArticleMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalArticleReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalArticleWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalArticleDao implements PortalArticleDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalArticleDao.class);
    private static final String class_name = DefaultPortalArticleDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalArticleMapper portalarticleMapper;
    @Autowired
    private PortalArticleWriteMapper portalarticleWriteMapper;
    @Autowired
    private PortalArticleReadMapper portalarticleReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalArticleModel item) {
        PortalArticle portalarticle = modelConvert(item);
        try {
            int id = portalarticleWriteMapper.insert(portalarticle);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalarticle.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalArticleModel update(PortalArticleModel item) {
        PortalArticle portalarticle = modelConvert(item);
        try {
            int id = portalarticleWriteMapper.updateByPrimaryKey(portalarticle);
            return id > 0 ? item : null;
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return null;
    }

    /**
     * get model     *     * @param id     * @return
     */
    @Override
    public PortalArticleModel getModelById(Long id) {
        try {
            PortalArticle item = portalarticleReadMapper.selectByPrimaryKey((Long) id);
            if (null == item) return null;
            return modelConvert(item);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return null;
    }

    /**
     * get model
     * * @param id
     * * @return
     */
    @Override
    public PortalArticleModel getModelWithBlobById(Long id) {

        PortalArticleExample portalarticleExample = new PortalArticleExample();
        PortalArticleExample.Criteria criteria = portalarticleExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<PortalArticle> item = portalarticleReadMapper.selectByExampleWithBLOBs(portalarticleExample);
        if (null != item && item.size() > 0) {
            return modelConvert(item.get(0));
        }
        return null;
    }

    /**
     * get list     *     * @return
     */
    @Override
    public List<PortalArticleModel> getAllList() {
        PortalArticleExample portalarticleExample = new PortalArticleExample();
        PortalArticleExample.Criteria criteria = portalarticleExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalArticle> items = portalarticleReadMapper.selectByExample(portalarticleExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalArticleModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalArticleExample portalarticleExample = new PortalArticleExample();
        PortalArticleExample.Criteria criteria = portalarticleExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalarticleExample.setPageIndex(pageIndex);
        portalarticleExample.setPageCount(pageSize);
        portalarticleExample.setOrderByClause(order_desc_where);
        List<PortalArticle> items = portalarticleReadMapper.selectByExample(portalarticleExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalArticleExample portalarticleExample = new PortalArticleExample();
        PortalArticleExample.Criteria criteria = portalarticleExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalarticleReadMapper.countByExample(portalarticleExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalArticle modelConvert(PortalArticleModel item) {
        PortalArticle result = new PortalArticle();
        result.setId(item.getId());
        result.setTitle(item.getTitle());
        result.setSubTitle(item.getSubTitle());
        result.setIcon(item.getIcon());
        result.setLink(item.getLink());
        if (item.getContents() != null) {
            result.setContents(item.getContents().getBytes());
        }
        result.setAr(item.getAr());
        result.setStatus(item.getStatus());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalArticleModel modelConvert(PortalArticle item) {
        PortalArticleModel result = new PortalArticleModel();
        result.setId(item.getId());
        result.setTitle(item.getTitle());
        result.setSubTitle(item.getSubTitle());
        result.setIcon(item.getIcon());
        result.setLink(item.getLink());
        try {
            if (item.getContents() != null)
                result.setContents(new String(item.getContents(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        result.setAr(item.getAr());
        result.setStatus(item.getStatus());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalArticleModel> modelListConvert(List<PortalArticle> items) {
        List<PortalArticleModel> result = new ArrayList<PortalArticleModel>() {
        };
        for (PortalArticle item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalArticle> modelListConvert2(List<PortalArticleModel> items) {
        List<PortalArticle> result = new ArrayList<PortalArticle>() {
        };
        for (PortalArticleModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}