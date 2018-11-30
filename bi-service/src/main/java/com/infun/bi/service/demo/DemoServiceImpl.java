package com.infun.bi.service.demo;


import com.infun.bi.mybatis.mapper.master1.YfBrandMapper;
import com.infun.bi.mybatis.mapper.master2.YfOrdersMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Think on 2018/8/14.
 */
@Service
public class DemoServiceImpl implements IDemoService {

    private final static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    YfBrandMapper yfBrandMapper;
    @Autowired
    YfOrdersMapper yfOrdersMapper;


    @Override
    public Object test() throws Exception{
        Map map = new HashMap();
        map.put("Brand",yfBrandMapper.selectByPrimaryKey("3874888dd990498ea376be2082c537ed"));
        map.put("Order",yfOrdersMapper.selectByPrimaryKey("098acb350e424d65add0c95f42817ed3"));
        return map;

    }


}
