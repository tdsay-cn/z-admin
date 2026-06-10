package com.z.admin;

import com.z.admin.service.ISlaveTestService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZAdminApplicationTests {

    @Resource
    ISlaveTestService slaveTestService;

    @Test
    public void context() {
        for (int i = 0; i < 10; i++) {
            System.out.println(slaveTestService.getById(1));
        }
    }

}
