package com.gdeastriver.synchronization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.gdeastriver.synchronization.dao")
@EnableScheduling//启动定时任务配置
@SpringBootApplication
public class LocalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LocalApplication.class, args);

    }

}
