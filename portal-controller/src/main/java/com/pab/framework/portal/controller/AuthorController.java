package com.pab.framework.portal.controller;


import com.pab.framework.portal.biz.PortalUsersBiz;
import com.pab.framework.portal.models.PortalUsersModel;
import com.pab.framework.portal.utils.MD5;
import com.pab.framework.portal.utils.mybatis.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {
    @Autowired
    PortalUsersBiz portalUsersBiz;

    @RequestMapping(value = "/login")
    public ResponseData<String> Auth(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        ResponseData<String> responseData = new ResponseData<>();
        String token = UUID.randomUUID().toString();

        PortalUsersModel user = portalUsersBiz.login(username, MD5.getMD5(password));
        if (user != null) {

            request.getSession().setAttribute("user", user);
            response.addCookie(new Cookie("token", token));
            responseData.setCode(0);
            responseData.setMsg("ok");
        } else {
            responseData.setCode(100);
            responseData.setMsg("error");
        }
        return responseData;
    }

    @RequestMapping(value = "/logout")
    public boolean Logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("user", null);
        response.addCookie(new Cookie("token", ""));            /* 跳转登录*/
        String url = "/login";
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}