package com.pab.framework.portal;

import com.pab.framework.portal.biz.PortalRolesBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalRolesBizTest {
    @Autowired
    private PortalRolesBiz portalrolesBiz;

    @Test
    public void getModelById() {       /* PortalRolesModel model = portalrolesBiz.getModelById((Long)1);         Assert.assertThat(model.getId(), is("获取主键id")); */ }
}