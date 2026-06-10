package com.z.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableAsync 开启 @Async注解
public class ZAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZAdminApplication.class, args);
    }

}
