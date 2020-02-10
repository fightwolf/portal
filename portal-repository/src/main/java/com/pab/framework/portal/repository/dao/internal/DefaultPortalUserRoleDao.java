package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalUserRoleModel;
import com.pab.framework.portal.repository.dao.PortalUserRoleDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUserRoleExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalUserRoleMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalUserRoleReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalUserRoleWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalUserRoleDao implements PortalUserRoleDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalUserRoleDao.class);
    private static final String class_name = DefaultPortalUserRoleDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalUserRoleMapper portaluserroleMapper;
    @Autowired
    private PortalUserRoleWriteMapper portaluserroleWriteMapper;
    @Autowired
    private PortalUserRoleReadMapper portaluserroleReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalUserRoleModel item) {
        PortalUserRole portaluserrole = modelConvert(item);
        try {
            int id = portaluserroleWriteMapper.insert(portaluserrole);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portaluserrole.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalUserRoleModel update(PortalUserRoleModel item) {
        PortalUserRole portaluserrole = modelConvert(item);
        try {
            int id = portaluserroleWriteMapper.updateByPrimaryKey(portaluserrole);
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
    public PortalUserRoleModel getModelById(Long id) {
        try {
            PortalUserRole item = portaluserroleReadMapper.selectByPrimaryKey((Long) id);
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
    public List<PortalUserRoleModel> getAllList() {
        PortalUserRoleExample portaluserroleExample = new PortalUserRoleExample();
        PortalUserRoleExample.Criteria criteria = portaluserroleExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalUserRole> items = portaluserroleReadMapper.selectByExample(portaluserroleExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalUserRoleModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalUserRoleExample portaluserroleExample = new PortalUserRoleExample();
        PortalUserRoleExample.Criteria criteria = portaluserroleExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portaluserroleExample.setPageIndex(pageIndex);
        portaluserroleExample.setPageCount(pageSize);
        portaluserroleExample.setOrderByClause(order_desc_where);
        List<PortalUserRole> items = portaluserroleReadMapper.selectByExample(portaluserroleExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalUserRoleExample portaluserroleExample = new PortalUserRoleExample();
        PortalUserRoleExample.Criteria criteria = portaluserroleExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portaluserroleReadMapper.countByExample(portaluserroleExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalUserRole modelConvert(PortalUserRoleModel item) {
        PortalUserRole result = new PortalUserRole();
        result.setId(item.getId());
        result.setUserCode(item.getUserCode());
        result.setRoleCode(item.getRoleCode());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalUserRoleModel modelConvert(PortalUserRole item) {
        PortalUserRoleModel result = new PortalUserRoleModel();
        result.setId(item.getId());
        result.setUserCode(item.getUserCode());
        result.setRoleCode(item.getRoleCode());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalUserRoleModel> modelListConvert(List<PortalUserRole> items) {
        List<PortalUserRoleModel> result = new ArrayList<PortalUserRoleModel>() {
        };
        for (PortalUserRole item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalUserRole> modelListConvert2(List<PortalUserRoleModel> items) {
        List<PortalUserRole> result = new ArrayList<PortalUserRole>() {
        };
        for (PortalUserRoleModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}