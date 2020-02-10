package com.pab.framework.portal.controller;

import com.pab.framework.portal.biz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Controller
public class HomeController {
    @Autowired
    PortalActionLogsBiz portalactionlogsBiz;
    @Autowired
    PortalArticleBiz portalarticleBiz;
    @Autowired
    PortalGroupBiz portalgroupBiz;
    @Autowired
    PortalModuleBiz portalmoduleBiz;
    @Autowired
    PortalNoticeBiz portalnoticeBiz;
    @Autowired
    PortalProjectBiz portalprojectBiz;
    @Autowired
    PortalProjectRoleBiz portalprojectroleBiz;
    @Autowired
    PortalRoleGroupBiz portalrolegroupBiz;
    @Autowired
    PortalRolesBiz portalrolesBiz;
    @Autowired
    PortalUserGroupBiz portalusergroupBiz;
    @Autowired
    PortalUserRoleBiz portaluserroleBiz;
    @Autowired
    PortalUsersBiz portalusersBiz;

    @RequestMapping(value = "/dashboard")
    public String dashboard(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "dashboard";
    }
    @RequestMapping(value = "/")
    public String dash(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "dashboard";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "login";
    }

    @RequestMapping(value = "/portalactionlogs/detail")
    public String portalactionlogsDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalactionlogsBiz.getModelById(id));
        return "PortalActionLogs/detail";
    }

    @RequestMapping(value = "/portalactionlogs/list")
    public String portalactionlogsList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalactionlogs/list";
    }

    @RequestMapping(value = "/portalarticle/detail")
    public String portalarticleDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalarticleBiz.getModelWithBlobById(id));
        return "PortalArticle/detail";
    }

    @RequestMapping(value = "/portalarticle/list")
    public String portalarticleList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalarticle/list";
    }

    @RequestMapping(value = "/portalgroup/detail")
    public String portalgroupDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalgroupBiz.getModelById(id));
        return "PortalGroup/detail";
    }

    @RequestMapping(value = "/portalgroup/list")
    public String portalgroupList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalgroup/list";
    }

    @RequestMapping(value = "/portalmodule/detail")
    public String portalmoduleDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalmoduleBiz.getModelById(id));
        return "PortalModule/detail";
    }

    @RequestMapping(value = "/portalmodule/list")
    public String portalmoduleList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalmodule/list";
    }

    @RequestMapping(value = "/portalnotice/detail")
    public String portalnoticeDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalnoticeBiz.getModelWithBlobById(id));
        return "PortalNotice/detail";
    }

    @RequestMapping(value = "/portalnotice/list")
    public String portalnoticeList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalnotice/list";
    }

    @RequestMapping(value = "/portalproject/detail")
    public String portalprojectDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalprojectBiz.getModelById(id));
        return "PortalProject/detail";
    }

    @RequestMapping(value = "/portalproject/list")
    public String portalprojectList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalproject/list";
    }

    @RequestMapping(value = "/portalprojectrole/detail")
    public String portalprojectroleDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalprojectroleBiz.getModelById(id));
        return "PortalProjectRole/detail";
    }

    @RequestMapping(value = "/portalprojectrole/list")
    public String portalprojectroleList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalprojectrole/list";
    }

    @RequestMapping(value = "/portalrolegroup/detail")
    public String portalrolegroupDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalrolegroupBiz.getModelById(id));
        return "PortalRoleGroup/detail";
    }

    @RequestMapping(value = "/portalrolegroup/list")
    public String portalrolegroupList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalrolegroup/list";
    }

    @RequestMapping(value = "/portalroles/detail")
    public String portalrolesDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalrolesBiz.getModelById(id));
        return "PortalRoles/detail";
    }

    @RequestMapping(value = "/portalroles/list")
    public String portalrolesList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalroles/list";
    }

    @RequestMapping(value = "/portalusergroup/detail")
    public String portalusergroupDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalusergroupBiz.getModelById(id));
        return "PortalUserGroup/detail";
    }

    @RequestMapping(value = "/portalusergroup/list")
    public String portalusergroupList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalusergroup/list";
    }

    @RequestMapping(value = "/portaluserrole/detail")
    public String portaluserroleDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portaluserroleBiz.getModelById(id));
        return "PortalUserRole/detail";
    }

    @RequestMapping(value = "/portaluserrole/list")
    public String portaluserroleList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portaluserrole/list";
    }

    @RequestMapping(value = "/portalusers/detail")
    public String portalusersDetail(Model model, Long id) throws Exception {
        model.addAttribute("item", portalusersBiz.getModelById(id));
        return "PortalUsers/detail";
    }

    @RequestMapping(value = "/portalusers/list")
    public String portalusersList(Model model) throws Exception {
        String str = null;
        model.addAttribute("name", "this is a test!");
        return "portalusers/list";
    }
}