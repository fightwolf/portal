package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalProjectModel;
import com.pab.framework.portal.repository.dao.PortalProjectDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProject;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalProjectMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalProjectReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalProjectWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalProjectDao implements PortalProjectDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalProjectDao.class);
    private static final String class_name = DefaultPortalProjectDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalProjectMapper portalprojectMapper;
    @Autowired
    private PortalProjectWriteMapper portalprojectWriteMapper;
    @Autowired
    private PortalProjectReadMapper portalprojectReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalProjectModel item) {
        PortalProject portalproject = modelConvert(item);
        try {
            int id = portalprojectWriteMapper.insert(portalproject);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalproject.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalProjectModel update(PortalProjectModel item) {
        PortalProject portalproject = modelConvert(item);
        try {
            int id = portalprojectWriteMapper.updateByPrimaryKey(portalproject);
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
    public PortalProjectModel getModelById(Long id) {
        try {
            PortalProject item = portalprojectReadMapper.selectByPrimaryKey((Long) id);
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
    public List<PortalProjectModel> getAllList() {
        PortalProjectExample portalprojectExample = new PortalProjectExample();
        PortalProjectExample.Criteria criteria = portalprojectExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalProject> items = portalprojectReadMapper.selectByExample(portalprojectExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalProjectModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalProjectExample portalprojectExample = new PortalProjectExample();
        PortalProjectExample.Criteria criteria = portalprojectExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalprojectExample.setPageIndex(pageIndex);
        portalprojectExample.setPageCount(pageSize);
        portalprojectExample.setOrderByClause(order_desc_where);
        List<PortalProject> items = portalprojectReadMapper.selectByExample(portalprojectExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalProjectExample portalprojectExample = new PortalProjectExample();
        PortalProjectExample.Criteria criteria = portalprojectExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalprojectReadMapper.countByExample(portalprojectExample);
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalProject modelConvert(PortalProjectModel item) {
        PortalProject result = new PortalProject();
        result.setId(item.getId());
        result.setProjectCode(item.getProjectCode());
        result.setProjectName(item.getProjectName());
        result.setProjectType(item.getProjectType());
        result.setParentCode(item.getParentCode());
        result.setUrl(item.getUrl());
        result.setUrlName(item.getUrlName());
        result.setDescribes(item.getDescribes());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalProjectModel modelConvert(PortalProject item) {
        PortalProjectModel result = new PortalProjectModel();
        result.setId(item.getId());
        result.setProjectCode(item.getProjectCode());
        result.setProjectName(item.getProjectName());
        result.setProjectType(item.getProjectType());
        result.setParentCode(item.getParentCode());
        result.setUrl(item.getUrl());
        result.setUrlName(item.getUrlName());
        result.setDescribes(item.getDescribes());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalProjectModel> modelListConvert(List<PortalProject> items) {
        List<PortalProjectModel> result = new ArrayList<PortalProjectModel>() {
        };
        for (PortalProject item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalProject> modelListConvert2(List<PortalProjectModel> items) {
        List<PortalProject> result = new ArrayList<PortalProject>() {
        };
        for (PortalProjectModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}