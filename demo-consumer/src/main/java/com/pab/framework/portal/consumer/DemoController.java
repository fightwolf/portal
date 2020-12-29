package com.pab.framework.portal.consumer;

import com.pab.framework.portal.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Reference(version = "1.0.0")
    private TestService testServiceImpl;

    @RequestMapping("/ins")
    public String ins(){
        testServiceImpl.ins();
        return "ins";
    }


    @RequestMapping("/del")
    public String del(){
        testServiceImpl.del();
        return "del";
    }


    @RequestMapping("/sel")
    public String sel(){
        testServiceImpl.sel();
        return "sel";
    }


    @RequestMapping("/upd")
    public String upd(){
        testServiceImpl.upd();
        return "upd";
    }
}
