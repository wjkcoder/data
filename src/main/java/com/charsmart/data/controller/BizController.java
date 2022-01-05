package com.charsmart.data.controller;

import com.charsmart.data.common.Result;
import com.charsmart.data.domain.DomainService;
import com.charsmart.data.domain.ServiceA;
import com.charsmart.data.domain.impl.DomainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Author: Wonder
 * @Date: Created on 2021/12/17 上午11:32
 */
@RestController
public class BizController {
    private final DomainService service;
    @Autowired
    public List<ServiceA> serviceAs;

    public BizController(DomainServiceImpl service) {
        this.service = service;
    }

    @RequestMapping("/user-info")
    public Result userInfo(String userName) {
        return service.userInfo(userName);
    }

    @PutMapping("/save")
    public Result saveUser(String userName, String phoneNum) {
        return service.saveUser(userName, phoneNum);
    }

    @PostConstruct
    public void init() {
        for (ServiceA serviceA : serviceAs) {
            serviceA.show();
        }
    }
}
