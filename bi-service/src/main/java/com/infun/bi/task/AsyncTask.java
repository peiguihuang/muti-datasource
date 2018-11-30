package com.infun.bi.task;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class AsyncTask {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Async("myTaskAsyncPool")  //myTaskAsynPool即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
    public void recodeOperationLog() {
        logger.info("记录操作日志" );
        mongoTemplate.insert(null);
        logger.info("记录操作日志成功");

    }


}
