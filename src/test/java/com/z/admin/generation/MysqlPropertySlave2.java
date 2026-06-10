package com.z.admin.generation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tdsay
 * @description mysql从库2配置
 */
@Data
@Component
public class MysqlPropertySlave2 {
    @Value("${spring.datasource.dynamic.datasource.slave_2.url}")
    private String url;

    @Value("${spring.datasource.dynamic.datasource.slave_2.username}")
    private String username;

    @Value("${spring.datasource.dynamic.datasource.slave_2.password}")
    private String password;
}