package com.pab.framework.portal.controller;

import com.alibaba.fastjson.JSON;
import com.pab.framework.portal.biz.PortalArticleBiz;
import com.pab.framework.portal.models.PortalArticleModel;
import com.pab.framework.portal.utils.mybatis.Pagination;
import com.pab.framework.portal.utils.mybatis.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/PortalArticle")
public class PortalArticleController {
    @Autowired
    PortalArticleBiz portalarticleBiz;

    @RequestMapping(value = "/get")
    public ResponseData<PortalArticleModel> get(Long id) {
        ResponseData<PortalArticleModel> responseData = new ResponseData<>();
        try {
            responseData.setCode(0);
            responseData.setMsg("success");
            responseData.setData(portalarticleBiz.getModelById(id));
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setCode(1);
            responseData.setMsg(e.getMessage());
        }
        return responseData;
    }

    @RequestMapping(value = "/getModel")
    public ResponseData<PortalArticleModel> getModel(Long id) {

        ResponseData<PortalArticleModel> responseData = new ResponseData<>();

        try {
            responseData.setCode(0);
            responseData.setMsg("success");
            responseData.setData(portalarticleBiz.getModelWithBlobById(id));
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setCode(1);
            responseData.setMsg(e.getMessage());
        }

        return responseData;
    }

    @PostMapping(value = "/save")
    public ResponseData<PortalArticleModel> save(String datas) {
        PortalArticleModel item = JSON.parseObject(datas, PortalArticleModel.class);
        ;
        ResponseData<PortalArticleModel> responseData = new ResponseData<>();
        try {
            responseData.setCode(0);
            responseData.setMsg("success");
            if (item.getId() > 0) {
                portalarticleBiz.update(item);
            } else {
                portalarticleBiz.add(item);
            }
            responseData.setData(item);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setCode(1);
            responseData.setMsg(e.getMessage());
        }
        return responseData;
    }

    @RequestMapping(value = "/getPageList")
    public ResponseData<Pagination> getPageList(@RequestParam(value = "pageIndex", required = true) int pageIndex, @RequestParam(value = "pageSize", required = true) int pageSize, @RequestParam(value = "key", required = false) String key) {
        ResponseData<Pagination> responseData = new ResponseData<>();
        responseData.setCode(0);
        responseData.setMsg("success");
        responseData.setData(portalarticleBiz.getPageList(pageIndex, pageSize, key));
        return responseData;
    }
}