package org.person.docker.autopublish.application.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class BeanLifeCycleCheck implements InitializingBean {

  @Value("${spring.main.banner-mode}")
  private String bannerMode;

  public BeanLifeCycleCheck() {//1st called
    log.info("BeanLifeCycleCheck::constructor called, at the moment, bannerMode = {}", bannerMode);
  }

  public void initMethod() {//4th called, it will triggered in ApplicationConfig.java
    log.info("BeanLifeCycleCheck: initMethod = {}", bannerMode);
  }

  @PostConstruct
  public void postConstruct() {//2nd called
    log.info("BeanLifeCycleCheck: postConstruct = {}", bannerMode);
  }

  @PreDestroy
  public void preDestroy() {
    log.info("BeanLifeCycleCheck: preDestroy = {}", bannerMode);
  }

  @Override
  public void afterPropertiesSet() throws Exception {//3rd called
    log.info("BeanLifeCycleCheck: afterPropertiesSet = {}", bannerMode);
  }
}
