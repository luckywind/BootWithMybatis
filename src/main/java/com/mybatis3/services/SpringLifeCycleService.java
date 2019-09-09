package com.mybatis3.services;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SpringLifeCycleService implements InitializingBean, DisposableBean {
    /**
     * 定制bean的初始化及销毁
     * @throws Exception
     */
/*    @PostConstruct
    public void start(){
        LOGGER.info("AnnotationBean start");
    }

    @PreDestroy
    public void destroy(){
        LOGGER.info("AnnotationBean destroy");
    }*/

    @Override
    public void destroy() throws Exception {
        Logger logger = Logger.getLogger(SpringLifeCycleService.class.getName());
        logger.info(SpringLifeCycleService.class.getName()+" destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Logger logger = Logger.getLogger(SpringLifeCycleService.class.getName());
        logger.info(SpringLifeCycleService.class.getName()+" afterPropertiesSet");
    }
}
