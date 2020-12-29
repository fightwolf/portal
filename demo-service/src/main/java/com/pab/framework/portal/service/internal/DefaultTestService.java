package com.pab.framework.portal.service.internal;

import com.pab.framework.portal.service.TestService;
import org.apache.dubbo.config.annotation.Service;


@Service(version = "1.0.0",interfaceClass = TestService.class)
public class DefaultTestService implements TestService {


    @Override
    public void ins() {
        System.out.println("==========++>ins");
    }

    @Override
    public void del() {
        System.out.println("==========++>del");

    }

    @Override
    public void upd() {
        System.out.println("==========++>upd");

    }

    @Override
    public void sel() {
        System.out.println("==========++>sel");

    }
}
