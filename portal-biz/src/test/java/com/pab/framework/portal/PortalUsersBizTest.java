package com.pab.framework.portal;

import com.pab.framework.portal.biz.PortalUsersBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalUsersBizTest {
    @Autowired
    private PortalUsersBiz portalusersBiz;

    @Test
    public void getModelById() {       /* PortalUsersModel model = portalusersBiz.getModelById((Long)1);         Assert.assertThat(model.getId(), is("获取主键id")); */ }
}