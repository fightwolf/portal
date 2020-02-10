package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalGroupModel;
import com.pab.framework.portal.repository.dao.PortalGroupDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalGroupExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalGroupMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalGroupReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalGroupWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalGroupDao implements PortalGroupDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalGroupDao.class);
    private static final String class_name = DefaultPortalGroupDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalGroupMapper portalgroupMapper;
    @Autowired
    private PortalGroupWriteMapper portalgroupWriteMapper;
    @Autowired
    private PortalGroupReadMapper portalgroupReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalGroupModel item) {
        PortalGroup portalgroup = modelConvert(item);
        try {
            int id = portalgroupWriteMapper.insert(portalgroup);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalgroup.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalGroupModel update(PortalGroupModel item) {
        PortalGroup portalgroup = modelConvert(item);
        try {
            int id = portalgroupWriteMapper.updateByPrimaryKey(portalgroup);
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
    public PortalGroupModel getModelById(Long id) {
        try {
            PortalGroup item = portalgroupReadMapper.selectByPrimaryKey((Long) id);
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
    public List<PortalGroupModel> getAllList() {
        PortalGroupExample portalgroupExample = new PortalGroupExample();
        PortalGroupExample.Criteria criteria = portalgroupExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalGroup> items = portalgroupReadMapper.selectByExample(portalgroupExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalGroupModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalGroupExample portalgroupExample = new PortalGroupExample();
        PortalGroupExample.Criteria criteria = portalgroupExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalgroupExample.setPageIndex(pageIndex);
        portalgroupExample.setPageCount(pageSize);
        portalgroupExample.setOrderByClause(order_desc_where);
        List<PortalGroup> items = portalgroupReadMapper.selectByExample(portalgroupExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalGroupExample portalgroupExample = new PortalGroupExample();
        PortalGroupExample.Criteria criteria = portalgroupExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalgroupReadMapper.countByExample(portalgroupExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalGroup modelConvert(PortalGroupModel item) {
        PortalGroup result = new PortalGroup();
        result.setId(item.getId());
        result.setRoleCode(item.getRoleCode());
        result.setRoleName(item.getRoleName());
        result.setAr(item.getAr());
        result.setDescribes(item.getDescribes());
        result.setStatus(item.getStatus());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalGroupModel modelConvert(PortalGroup item) {
        PortalGroupModel result = new PortalGroupModel();
        result.setId(item.getId());
        result.setRoleCode(item.getRoleCode());
        result.setRoleName(item.getRoleName());
        result.setAr(item.getAr());
        result.setDescribes(item.getDescribes());
        result.setStatus(item.getStatus());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalGroupModel> modelListConvert(List<PortalGroup> items) {
        List<PortalGroupModel> result = new ArrayList<PortalGroupModel>() {
        };
        for (PortalGroup item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalGroup> modelListConvert2(List<PortalGroupModel> items) {
        List<PortalGroup> result = new ArrayList<PortalGroup>() {
        };
        for (PortalGroupModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}