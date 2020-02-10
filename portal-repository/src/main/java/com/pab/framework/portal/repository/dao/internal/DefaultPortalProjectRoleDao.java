package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalProjectRoleModel;
import com.pab.framework.portal.repository.dao.PortalProjectRoleDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRoleExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalProjectRoleMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalProjectRoleReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalProjectRoleWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalProjectRoleDao implements PortalProjectRoleDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalProjectRoleDao.class);
    private static final String class_name = DefaultPortalProjectRoleDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalProjectRoleMapper portalprojectroleMapper;
    @Autowired
    private PortalProjectRoleWriteMapper portalprojectroleWriteMapper;
    @Autowired
    private PortalProjectRoleReadMapper portalprojectroleReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalProjectRoleModel item) {
        PortalProjectRole portalprojectrole = modelConvert(item);
        try {
            int id = portalprojectroleWriteMapper.insert(portalprojectrole);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalprojectrole.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalProjectRoleModel update(PortalProjectRoleModel item) {
        PortalProjectRole portalprojectrole = modelConvert(item);
        try {
            int id = portalprojectroleWriteMapper.updateByPrimaryKey(portalprojectrole);
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
    public PortalProjectRoleModel getModelById(Long id) {
        try {
            PortalProjectRole item = portalprojectroleReadMapper.selectByPrimaryKey((Long) id);
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
    public List<PortalProjectRoleModel> getAllList() {
        PortalProjectRoleExample portalprojectroleExample = new PortalProjectRoleExample();
        PortalProjectRoleExample.Criteria criteria = portalprojectroleExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalProjectRole> items = portalprojectroleReadMapper.selectByExample(portalprojectroleExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalProjectRoleModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalProjectRoleExample portalprojectroleExample = new PortalProjectRoleExample();
        PortalProjectRoleExample.Criteria criteria = portalprojectroleExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalprojectroleExample.setPageIndex(pageIndex);
        portalprojectroleExample.setPageCount(pageSize);
        portalprojectroleExample.setOrderByClause(order_desc_where);
        List<PortalProjectRole> items = portalprojectroleReadMapper.selectByExample(portalprojectroleExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalProjectRoleExample portalprojectroleExample = new PortalProjectRoleExample();
        PortalProjectRoleExample.Criteria criteria = portalprojectroleExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalprojectroleReadMapper.countByExample(portalprojectroleExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalProjectRole modelConvert(PortalProjectRoleModel item) {
        PortalProjectRole result = new PortalProjectRole();
        result.setId(item.getId());
        result.setRoleCode(item.getRoleCode());
        result.setProjectCode(item.getProjectCode());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalProjectRoleModel modelConvert(PortalProjectRole item) {
        PortalProjectRoleModel result = new PortalProjectRoleModel();
        result.setId(item.getId());
        result.setRoleCode(item.getRoleCode());
        result.setProjectCode(item.getProjectCode());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalProjectRoleModel> modelListConvert(List<PortalProjectRole> items) {
        List<PortalProjectRoleModel> result = new ArrayList<PortalProjectRoleModel>() {
        };
        for (PortalProjectRole item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalProjectRole> modelListConvert2(List<PortalProjectRoleModel> items) {
        List<PortalProjectRole> result = new ArrayList<PortalProjectRole>() {
        };
        for (PortalProjectRoleModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}