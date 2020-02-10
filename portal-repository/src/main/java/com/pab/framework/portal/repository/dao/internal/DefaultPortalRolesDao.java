package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalRolesModel;
import com.pab.framework.portal.repository.dao.PortalRolesDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoles;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRolesExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalRolesMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalRolesReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalRolesWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalRolesDao implements PortalRolesDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalRolesDao.class);
    private static final String class_name = DefaultPortalRolesDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalRolesMapper portalrolesMapper;
    @Autowired
    private PortalRolesWriteMapper portalrolesWriteMapper;
    @Autowired
    private PortalRolesReadMapper portalrolesReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalRolesModel item) {
        PortalRoles portalroles = modelConvert(item);
        try {
            int id = portalrolesWriteMapper.insert(portalroles);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalroles.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalRolesModel update(PortalRolesModel item) {
        PortalRoles portalroles = modelConvert(item);
        try {
            int id = portalrolesWriteMapper.updateByPrimaryKey(portalroles);
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
    public PortalRolesModel getModelById(Long id) {
        try {
            PortalRoles item = portalrolesReadMapper.selectByPrimaryKey((Long) id);
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
    public List<PortalRolesModel> getAllList() {
        PortalRolesExample portalrolesExample = new PortalRolesExample();
        PortalRolesExample.Criteria criteria = portalrolesExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalRoles> items = portalrolesReadMapper.selectByExample(portalrolesExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalRolesModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalRolesExample portalrolesExample = new PortalRolesExample();
        PortalRolesExample.Criteria criteria = portalrolesExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalrolesExample.setPageIndex(pageIndex);
        portalrolesExample.setPageCount(pageSize);
        portalrolesExample.setOrderByClause(order_desc_where);
        List<PortalRoles> items = portalrolesReadMapper.selectByExample(portalrolesExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalRolesExample portalrolesExample = new PortalRolesExample();
        PortalRolesExample.Criteria criteria = portalrolesExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalrolesReadMapper.countByExample(portalrolesExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalRoles modelConvert(PortalRolesModel item) {
        PortalRoles result = new PortalRoles();
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

    private PortalRolesModel modelConvert(PortalRoles item) {
        PortalRolesModel result = new PortalRolesModel();
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

    private List<PortalRolesModel> modelListConvert(List<PortalRoles> items) {
        List<PortalRolesModel> result = new ArrayList<PortalRolesModel>() {
        };
        for (PortalRoles item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalRoles> modelListConvert2(List<PortalRolesModel> items) {
        List<PortalRoles> result = new ArrayList<PortalRoles>() {
        };
        for (PortalRolesModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}