package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalModuleModel;
import com.pab.framework.portal.repository.dao.PortalModuleDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalModule;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalModuleExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalModuleMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalModuleReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalModuleWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalModuleDao implements PortalModuleDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalModuleDao.class);
    private static final String class_name = DefaultPortalModuleDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalModuleMapper portalmoduleMapper;
    @Autowired
    private PortalModuleWriteMapper portalmoduleWriteMapper;
    @Autowired
    private PortalModuleReadMapper portalmoduleReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalModuleModel item) {
        PortalModule portalmodule = modelConvert(item);
        try {
            int id = portalmoduleWriteMapper.insert(portalmodule);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalmodule.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalModuleModel update(PortalModuleModel item) {
        PortalModule portalmodule = modelConvert(item);
        try {
            int id = portalmoduleWriteMapper.updateByPrimaryKey(portalmodule);
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
    public PortalModuleModel getModelById(Long id) {
        try {
            PortalModule item = portalmoduleReadMapper.selectByPrimaryKey((Long) id);
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
    public List<PortalModuleModel> getAllList() {
        PortalModuleExample portalmoduleExample = new PortalModuleExample();
        PortalModuleExample.Criteria criteria = portalmoduleExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalModule> items = portalmoduleReadMapper.selectByExample(portalmoduleExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalModuleModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalModuleExample portalmoduleExample = new PortalModuleExample();
        PortalModuleExample.Criteria criteria = portalmoduleExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalmoduleExample.setPageIndex(pageIndex);
        portalmoduleExample.setPageCount(pageSize);
        portalmoduleExample.setOrderByClause(order_desc_where);
        List<PortalModule> items = portalmoduleReadMapper.selectByExample(portalmoduleExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalModuleExample portalmoduleExample = new PortalModuleExample();
        PortalModuleExample.Criteria criteria = portalmoduleExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalmoduleReadMapper.countByExample(portalmoduleExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalModule modelConvert(PortalModuleModel item) {
        PortalModule result = new PortalModule();
        result.setId(item.getId());
        result.setModuleName(item.getModuleName());
        result.setModuleCode(item.getModuleCode());
        result.setParentCode(item.getParentCode());
        result.setIcon(item.getIcon());
        result.setLink(item.getLink());
        result.setDescribes(item.getDescribes());
        result.setAr(item.getAr());
        result.setStatus(item.getStatus());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalModuleModel modelConvert(PortalModule item) {
        PortalModuleModel result = new PortalModuleModel();
        result.setId(item.getId());
        result.setModuleName(item.getModuleName());
        result.setModuleCode(item.getModuleCode());
        result.setParentCode(item.getParentCode());
        result.setIcon(item.getIcon());
        result.setLink(item.getLink());
        result.setDescribes(item.getDescribes());
        result.setAr(item.getAr());
        result.setStatus(item.getStatus());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalModuleModel> modelListConvert(List<PortalModule> items) {
        List<PortalModuleModel> result = new ArrayList<PortalModuleModel>() {
        };
        for (PortalModule item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalModule> modelListConvert2(List<PortalModuleModel> items) {
        List<PortalModule> result = new ArrayList<PortalModule>() {
        };
        for (PortalModuleModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}