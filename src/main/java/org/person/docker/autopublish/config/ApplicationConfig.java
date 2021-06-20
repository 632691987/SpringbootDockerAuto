package org.person.docker.autopublish.config;

import org.person.docker.autopublish.application.bean.BeanLifeCycleCheck;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean(initMethod = "initMethod")
  public BeanLifeCycleCheck beanLifeCycleCheck() {
    return new BeanLifeCycleCheck();
  }

}
