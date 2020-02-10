package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalActionLogsModel;
import com.pab.framework.portal.repository.dao.PortalActionLogsDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalActionLogs;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalActionLogsExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalActionLogsMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalActionLogsReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalActionLogsWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalActionLogsDao implements PortalActionLogsDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalActionLogsDao.class);
    private static final String class_name = DefaultPortalActionLogsDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalActionLogsMapper portalactionlogsMapper;
    @Autowired
    private PortalActionLogsWriteMapper portalactionlogsWriteMapper;
    @Autowired
    private PortalActionLogsReadMapper portalactionlogsReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalActionLogsModel item) {
        PortalActionLogs portalactionlogs = modelConvert(item);
        try {
            int id = portalactionlogsWriteMapper.insert(portalactionlogs);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalactionlogs.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalActionLogsModel update(PortalActionLogsModel item) {
        PortalActionLogs portalactionlogs = modelConvert(item);
        try {
            int id = portalactionlogsWriteMapper.updateByPrimaryKey(portalactionlogs);
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
    public PortalActionLogsModel getModelById(Long id) {
        try {
            PortalActionLogs item = portalactionlogsReadMapper.selectByPrimaryKey((Long) id);
            if (null == item) return null;
            return modelConvert(item);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return null;
    }

    /**
     * get list     *     * @return
     */
    @Override
    public List<PortalActionLogsModel> getAllList() {
        PortalActionLogsExample portalactionlogsExample = new PortalActionLogsExample();
        PortalActionLogsExample.Criteria criteria = portalactionlogsExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalActionLogs> items = portalactionlogsReadMapper.selectByExample(portalactionlogsExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalActionLogsModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalActionLogsExample portalactionlogsExample = new PortalActionLogsExample();
        PortalActionLogsExample.Criteria criteria = portalactionlogsExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalactionlogsExample.setPageIndex(pageIndex);
        portalactionlogsExample.setPageCount(pageSize);
        portalactionlogsExample.setOrderByClause(order_desc_where);
        List<PortalActionLogs> items = portalactionlogsReadMapper.selectByExample(portalactionlogsExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalActionLogsExample portalactionlogsExample = new PortalActionLogsExample();
        PortalActionLogsExample.Criteria criteria = portalactionlogsExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalactionlogsReadMapper.countByExample(portalactionlogsExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalActionLogs modelConvert(PortalActionLogsModel item) {
        PortalActionLogs result = new PortalActionLogs();
        result.setId(item.getId());
        result.setOperationType(item.getOperationType());
        result.setOperationName(item.getOperationName());
        result.setParentCode(item.getParentCode());
        result.setDescribes(item.getDescribes());
        result.setIp(item.getIp());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalActionLogsModel modelConvert(PortalActionLogs item) {
        PortalActionLogsModel result = new PortalActionLogsModel();
        result.setId(item.getId());
        result.setOperationType(item.getOperationType());
        result.setOperationName(item.getOperationName());
        result.setParentCode(item.getParentCode());
        result.setDescribes(item.getDescribes());
        result.setIp(item.getIp());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalActionLogsModel> modelListConvert(List<PortalActionLogs> items) {
        List<PortalActionLogsModel> result = new ArrayList<PortalActionLogsModel>() {
        };
        for (PortalActionLogs item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalActionLogs> modelListConvert2(List<PortalActionLogsModel> items) {
        List<PortalActionLogs> result = new ArrayList<PortalActionLogs>() {
        };
        for (PortalActionLogsModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}