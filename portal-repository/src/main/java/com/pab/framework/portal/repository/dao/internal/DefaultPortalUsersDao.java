package com.pab.framework.portal.repository.dao.internal;

import com.pab.framework.portal.models.PortalUsersModel;
import com.pab.framework.portal.repository.dao.PortalUsersDao;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUsers;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalUsersExample;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read.PortalUsersMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.read.PortalUsersReadMapper;
import com.pab.framework.portal.repository.persistence.mybatis.provider.portal.handwrite.write.PortalUsersWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPortalUsersDao implements PortalUsersDao {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DefaultPortalUsersDao.class);
    private static final String class_name = DefaultPortalUsersDao.class.getName();
    private static final String order_desc_where = " Id desc";
    @Autowired
    private PortalUsersMapper portalusersMapper;
    @Autowired
    private PortalUsersWriteMapper portalusersWriteMapper;
    @Autowired
    private PortalUsersReadMapper portalusersReadMapper;

    /**
     * add     *     * @param item     * @return
     */
    @Override
    public Long add(PortalUsersModel item) {
        PortalUsers portalusers = modelConvert(item);
        try {
            int id = portalusersWriteMapper.insert(portalusers);
        } catch (Exception e) {
            log.error(class_name, e.getStackTrace());
        }
        return portalusers.getId();
    }

    /**
     * update     *     * @param item     * @return
     */
    @Override
    public PortalUsersModel update(PortalUsersModel item) {
        PortalUsers portalusers = modelConvert(item);
        try {
            int id = portalusersWriteMapper.updateByPrimaryKey(portalusers);
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
    public PortalUsersModel getModelById(Long id) {
        try {
            PortalUsers item = portalusersReadMapper.selectByPrimaryKey((Long) id);
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
    public List<PortalUsersModel> getAllList() {
        PortalUsersExample portalusersExample = new PortalUsersExample();
        PortalUsersExample.Criteria criteria = portalusersExample.createCriteria();         /*add any condition*/
        criteria.andIdIsNotNull();
        List<PortalUsers> items = portalusersReadMapper.selectByExample(portalusersExample);
        return modelListConvert(items);
    }

    /**
     * get pagelist     *     * @return
     */
    @Override
    public List<PortalUsersModel> getPageList(int pageIndex, int pageSize, String key) {
        PortalUsersExample portalusersExample = new PortalUsersExample();
        PortalUsersExample.Criteria criteria = portalusersExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        portalusersExample.setPageIndex(pageIndex);
        portalusersExample.setPageCount(pageSize);
        portalusersExample.setOrderByClause(order_desc_where);
        List<PortalUsers> items = portalusersReadMapper.selectByExample(portalusersExample);
        return modelListConvert(items);
    }

    /**
     * get count     *     * @return
     */
    @Override
    public int getCount(String key) {
        PortalUsersExample portalusersExample = new PortalUsersExample();
        PortalUsersExample.Criteria criteria = portalusersExample.createCriteria();
        if (!"".equals(key)) {/*add any condition*/ }
        criteria.andIdIsNotNull();
        return portalusersReadMapper.countByExample(portalusersExample);
    }

    @Override
    public PortalUsersModel login(String username, String password) {
        PortalUsersExample portalusersExample = new PortalUsersExample();
        PortalUsersExample.Criteria criteria = portalusersExample.createCriteria();         /*add any condition*/
        criteria.andUserNameEqualTo(username);
        criteria.andUserPwdEqualTo(password);
        List<PortalUsers> items = portalusersReadMapper.selectByExample(portalusersExample);
        if (items.size() > 0)
            return modelConvert(items.get(0));
        return null;
    }

    /**
     * private method:change model     *     * @param item     * @return
     */
    private PortalUsers modelConvert(PortalUsersModel item) {
        PortalUsers result = new PortalUsers();
        result.setId(item.getId());
        result.setUserCode(item.getUserCode());
        result.setUserName(item.getUserName());
        result.setUserPwd(item.getUserPwd());
        result.setUserType(item.getUserType());
        result.setUserEmail(item.getUserEmail());
        result.setUserPhone(item.getUserPhone());
        result.setAvatar(item.getAvatar());
        result.setRegisteIp(item.getRegisteIp());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private PortalUsersModel modelConvert(PortalUsers item) {
        PortalUsersModel result = new PortalUsersModel();
        result.setId(item.getId());
        result.setUserCode(item.getUserCode());
        result.setUserName(item.getUserName());
        result.setUserPwd(item.getUserPwd());
        result.setUserType(item.getUserType());
        result.setUserEmail(item.getUserEmail());
        result.setUserPhone(item.getUserPhone());
        result.setAvatar(item.getAvatar());
        result.setRegisteIp(item.getRegisteIp());
        result.setCreatorId(item.getCreatorId());
        result.setCreatorName(item.getCreatorName());
        result.setCreateTimestamp(item.getCreateTimestamp());
        result.setLastUpdateTimestamp(item.getLastUpdateTimestamp());
        return result;
    }

    private List<PortalUsersModel> modelListConvert(List<PortalUsers> items) {
        List<PortalUsersModel> result = new ArrayList<PortalUsersModel>() {
        };
        for (PortalUsers item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }

    private List<PortalUsers> modelListConvert2(List<PortalUsersModel> items) {
        List<PortalUsers> result = new ArrayList<PortalUsers>() {
        };
        for (PortalUsersModel item : items) {
            result.add(modelConvert(item));
        }
        return result;
    }
}