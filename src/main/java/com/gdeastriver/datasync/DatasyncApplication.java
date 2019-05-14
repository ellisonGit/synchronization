package com.gdeastriver.datasync;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.gdeastriver.datasync.dao")
@EnableScheduling//启动定时任务配置
@SpringBootApplication
public class DatasyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasyncApplication.class, args);
    }

}
