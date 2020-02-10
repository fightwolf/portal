package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalUserGroupModel;
import com.pab.framework.portal.repository.dao.PortalUserGroupDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserGroup;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserGroupExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalUserGroupMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalUserGroupReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalUserGroupWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalUserGroupDao implements PortalUserGroupDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalUserGroupDao.class);
    private static final String class_name = DefaultPortalUserGroupDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalUserGroupMapper portalusergroupMapper;
    @Autowired
    private PortalUserGroupWriteMapper portalusergroupWriteMapper;
    @Autowired
    private PortalUserGroupReadMapper portalusergroupReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalUserGroupModel item) {
        PortalUserGroup portalusergroup = modelConvert(item);
        try {
            int id = portalusergroupWriteMapper.insert(portalusergroup);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalusergroup.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalUserGroupModel update(PortalUserGroupModel item) {
        PortalUserGroup portalusergroup = modelConvert(item);
        try {
            int id = portalusergroupWriteMapper.updateByPrimaryKey(portalusergroup);
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
    public PortalUserGroupModel getModelById(Long id) {
        try {
            PortalUserGroup item = portalusergroupReadMapper.selectByPrimaryKey((Long) id);
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
    public List<PortalUserGroupModel> getAllList() {
        PortalUserGroupExample portalusergroupExample = new PortalUserGroupExample();
        PortalUserGroupExample.Criteria criteria = portalusergroupExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalUserGroup> items = portalusergroupReadMapper.selectByExample(portalusergroupExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalUserGroupModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalUserGroupExample portalusergroupExample = new PortalUserGroupExample();
        PortalUserGroupExample.Criteria criteria = portalusergroupExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalusergroupExample.setPageIndex(pageIndex);
        portalusergroupExample.setPageCount(pageSize);
        portalusergroupExample.setOrderByClause(order_desc_where);
        List<PortalUserGroup> items = portalusergroupReadMapper.selectByExample(portalusergroupExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalUserGroupExample portalusergroupExample = new PortalUserGroupExample();
        PortalUserGroupExample.Criteria criteria = portalusergroupExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalusergroupReadMapper.countByExample(portalusergroupExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalUserGroup modelConvert(PortalUserGroupModel item) {
        PortalUserGroup result = new PortalUserGroup();
        result.setId(item.getId());
        result.setUserCode(item.getUserCode());
        result.setRoleCode(item.getRoleCode());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalUserGroupModel modelConvert(PortalUserGroup item) {
        PortalUserGroupModel result = new PortalUserGroupModel();
        result.setId(item.getId());
        result.setUserCode(item.getUserCode());
        result.setRoleCode(item.getRoleCode());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalUserGroupModel> modelListConvert(List<PortalUserGroup> items) {
        List<PortalUserGroupModel> result = new ArrayList<PortalUserGroupModel>() {
        };
        for (PortalUserGroup item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalUserGroup> modelListConvert2(List<PortalUserGroupModel> items) {
        List<PortalUserGroup> result = new ArrayList<PortalUserGroup>() {
        };
        for (PortalUserGroupModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}