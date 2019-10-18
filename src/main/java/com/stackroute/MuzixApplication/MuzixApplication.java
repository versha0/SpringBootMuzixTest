package com.stackroute.MuzixApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MuzixApplication {
//    @Bean
//    MyBean myBean() {
//        return new MyBean();
//    }


    public static void main(String[] args) {
       SpringApplication.run(MuzixApplication.class, args);
//        MyBean myBean = context.getBean(MyBean.class);
//        myBean.startApplication();

    }
//    private static class MyBean {
//
//        @Value("${app.title}")
//        private String appTitle;
//
//        public void startApplication() {
//            System.out.printf("-- running application: %s --%n", appTitle);
//
//
//    }
}
