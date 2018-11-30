package com.infun.bi.web.demo;


import com.infun.bi.common.ResultMap;
import com.infun.bi.exception.ErrorCode;
import com.infun.bi.service.demo.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/v1.0/bi")
public class DemoController {

    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);


    @Autowired
    IDemoService demoService;


    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public Object addSupplyAccount() {
        ResultMap rMap = new ResultMap();
        try {

            rMap.success();
            rMap.data(demoService.test());
            rMap.map().put("resultCode", ErrorCode.SUCCESS.code());
            return rMap.map();
        } catch (Exception e) {
            rMap.failure();
            rMap.errmsg(e.getMessage());
            rMap.map().put("resultCode", ErrorCode.ERROR.code());
            logger.error(e.getMessage());
            e.printStackTrace();
            return rMap.map();
        }
    }



}


