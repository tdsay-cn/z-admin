package com.z.admin.generation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tdsay
 * @description mysql从库1配置
 */
@Data
@Component
public class MysqlPropertySlave1 {
    @Value("${spring.datasource.dynamic.datasource.slave_1.url}")
    private String url;

    @Value("${spring.datasource.dynamic.datasource.slave_1.username}")
    private String username;

    @Value("${spring.datasource.dynamic.datasource.slave_1.password}")
    private String password;
}