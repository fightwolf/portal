package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalNoticeModel;
import com.pab.framework.portal.repository.dao.PortalNoticeDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNotice;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNoticeExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalNoticeMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalNoticeReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalNoticeWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalNoticeDao implements PortalNoticeDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalNoticeDao.class);
    private static final String class_name = DefaultPortalNoticeDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalNoticeMapper portalnoticeMapper;
    @Autowired
    private PortalNoticeWriteMapper portalnoticeWriteMapper;
    @Autowired
    private PortalNoticeReadMapper portalnoticeReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalNoticeModel item) {
        PortalNotice portalnotice = modelConvert(item);
        try {
            int id = portalnoticeWriteMapper.insert(portalnotice);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalnotice.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalNoticeModel update(PortalNoticeModel item) {
        PortalNotice portalnotice = modelConvert(item);
        try {
            int id = portalnoticeWriteMapper.updateByPrimaryKey(portalnotice);
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
    public PortalNoticeModel getModelById(Long id) {
        try {
            PortalNotice item = portalnoticeReadMapper.selectByPrimaryKey((Long) id);
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
    public PortalNoticeModel getModelWithBlobById(Long id) {

        PortalNoticeExample portalnoticeExample = new PortalNoticeExample();
        PortalNoticeExample.Criteria criteria = portalnoticeExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<PortalNotice> item = portalnoticeReadMapper.selectByExampleWithBLOBs(portalnoticeExample);
        if (null != item && item.size() > 0) {
            return modelConvert(item.get(0));
        }
        return null;
    }

    /**
     * get list     *     * @return
     */
    @Override
    public List<PortalNoticeModel> getAllList() {
        PortalNoticeExample portalnoticeExample = new PortalNoticeExample();
        PortalNoticeExample.Criteria criteria = portalnoticeExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalNotice> items = portalnoticeReadMapper.selectByExample(portalnoticeExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalNoticeModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalNoticeExample portalnoticeExample = new PortalNoticeExample();
        PortalNoticeExample.Criteria criteria = portalnoticeExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalnoticeExample.setPageIndex(pageIndex);
        portalnoticeExample.setPageCount(pageSize);
        portalnoticeExample.setOrderByClause(order_desc_where);
        List<PortalNotice> items = portalnoticeReadMapper.selectByExample(portalnoticeExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalNoticeExample portalnoticeExample = new PortalNoticeExample();
        PortalNoticeExample.Criteria criteria = portalnoticeExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalnoticeReadMapper.countByExample(portalnoticeExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalNotice modelConvert(PortalNoticeModel item) {
        PortalNotice result = new PortalNotice();
        result.setId(item.getId());
        result.setTitle(item.getTitle());
        result.setSubTitle(item.getSubTitle());
        result.setPositionId(item.getPositionId());
        result.setPositionName(item.getPositionName());
        result.setIcon(item.getIcon());
        result.setLink(item.getLink());
        result.setBeginTimes(item.getBeginTimes());
        result.setEndTimes(item.getEndTimes());
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

    private PortalNoticeModel modelConvert(PortalNotice item) {
        PortalNoticeModel result = new PortalNoticeModel();
        result.setId(item.getId());
        result.setTitle(item.getTitle());
        result.setSubTitle(item.getSubTitle());
        result.setPositionId(item.getPositionId());
        result.setPositionName(item.getPositionName());
        result.setIcon(item.getIcon());
        result.setLink(item.getLink());
        result.setBeginTimes(item.getBeginTimes());
        result.setEndTimes(item.getEndTimes());
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

    private List<PortalNoticeModel> modelListConvert(List<PortalNotice> items) {
        List<PortalNoticeModel> result = new ArrayList<PortalNoticeModel>() {
        };
        for (PortalNotice item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalNotice> modelListConvert2(List<PortalNoticeModel> items) {
        List<PortalNotice> result = new ArrayList<PortalNotice>() {
        };
        for (PortalNoticeModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}