package com.pab.framework.portal.controller;

import com.alibaba.fastjson.JSON;
import com.pab.framework.portal.biz.PortalNoticeBiz;
import com.pab.framework.portal.models.PortalNoticeModel;
import com.pab.framework.portal.utils.mybatis.Pagination;
import com.pab.framework.portal.utils.mybatis.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/PortalNotice")
public class PortalNoticeController {
    @Autowired
    PortalNoticeBiz portalnoticeBiz;

    @RequestMapping(value = "/get")
    public ResponseData<PortalNoticeModel> get(Long id) {
        ResponseData<PortalNoticeModel> responseData = new ResponseData<>();
        try {
            responseData.setCode(0);
            responseData.setMsg("success");
            responseData.setData(portalnoticeBiz.getModelById(id));
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setCode(1);
            responseData.setMsg(e.getMessage());
        }
        return responseData;
    }

    @RequestMapping(value = "/getModel")
    public ResponseData<PortalNoticeModel> getModel(Long id) {

        ResponseData<PortalNoticeModel> responseData = new ResponseData<>();

        try {
            responseData.setCode(0);
            responseData.setMsg("success");
            responseData.setData(portalnoticeBiz.getModelWithBlobById(id));
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setCode(1);
            responseData.setMsg(e.getMessage());
        }

        return responseData;
    }

    @PostMapping(value = "/save")
    public ResponseData<PortalNoticeModel> save(String datas) {
        PortalNoticeModel item = JSON.parseObject(datas, PortalNoticeModel.class);
        ;
        ResponseData<PortalNoticeModel> responseData = new ResponseData<>();
        try {
            responseData.setCode(0);
            responseData.setMsg("success");
            if (item.getId() > 0) {
                portalnoticeBiz.update(item);
            } else {
                portalnoticeBiz.add(item);
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
        responseData.setData(portalnoticeBiz.getPageList(pageIndex, pageSize, key));
        return responseData;
    }
}