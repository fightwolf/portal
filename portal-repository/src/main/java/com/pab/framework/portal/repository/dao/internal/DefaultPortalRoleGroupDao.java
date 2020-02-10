package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalRoleGroupModel;
import com.pab.framework.portal.repository.dao.PortalRoleGroupDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoleGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoleGroupExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalRoleGroupMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalRoleGroupReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalRoleGroupWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalRoleGroupDao implements PortalRoleGroupDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalRoleGroupDao.class);
    private static final String class_name = DefaultPortalRoleGroupDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalRoleGroupMapper portalrolegroupMapper;
    @Autowired
    private PortalRoleGroupWriteMapper portalrolegroupWriteMapper;
    @Autowired
    private PortalRoleGroupReadMapper portalrolegroupReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalRoleGroupModel item) {
        PortalRoleGroup portalrolegroup = modelConvert(item);
        try {
            int id = portalrolegroupWriteMapper.insert(portalrolegroup);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalrolegroup.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalRoleGroupModel update(PortalRoleGroupModel item) {
        PortalRoleGroup portalrolegroup = modelConvert(item);
        try {
            int id = portalrolegroupWriteMapper.updateByPrimaryKey(portalrolegroup);
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
    public PortalRoleGroupModel getModelById(Long id) {
        try {
            PortalRoleGroup item = portalrolegroupReadMapper.selectByPrimaryKey((Long) id);
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
    public List<PortalRoleGroupModel> getAllList() {
        PortalRoleGroupExample portalrolegroupExample = new PortalRoleGroupExample();
        PortalRoleGroupExample.Criteria criteria = portalrolegroupExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalRoleGroup> items = portalrolegroupReadMapper.selectByExample(portalrolegroupExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalRoleGroupModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalRoleGroupExample portalrolegroupExample = new PortalRoleGroupExample();
        PortalRoleGroupExample.Criteria criteria = portalrolegroupExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalrolegroupExample.setPageIndex(pageIndex);
        portalrolegroupExample.setPageCount(pageSize);
        portalrolegroupExample.setOrderByClause(order_desc_where);
        List<PortalRoleGroup> items = portalrolegroupReadMapper.selectByExample(portalrolegroupExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalRoleGroupExample portalrolegroupExample = new PortalRoleGroupExample();
        PortalRoleGroupExample.Criteria criteria = portalrolegroupExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalrolegroupReadMapper.countByExample(portalrolegroupExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalRoleGroup modelConvert(PortalRoleGroupModel item) {
        PortalRoleGroup result = new PortalRoleGroup();
        result.setId(item.getId());
        result.setGroupCode(item.getGroupCode());
        result.setRoleCode(item.getRoleCode());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalRoleGroupModel modelConvert(PortalRoleGroup item) {
        PortalRoleGroupModel result = new PortalRoleGroupModel();
        result.setId(item.getId());
        result.setGroupCode(item.getGroupCode());
        result.setRoleCode(item.getRoleCode());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalRoleGroupModel> modelListConvert(List<PortalRoleGroup> items) {
        List<PortalRoleGroupModel> result = new ArrayList<PortalRoleGroupModel>() {
        };
        for (PortalRoleGroup item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalRoleGroup> modelListConvert2(List<PortalRoleGroupModel> items) {
        List<PortalRoleGroup> result = new ArrayList<PortalRoleGroup>() {
        };
        for (PortalRoleGroupModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}