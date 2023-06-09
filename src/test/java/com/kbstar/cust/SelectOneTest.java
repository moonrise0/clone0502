package com.kbstar.cust;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@Slf4j
@SpringBootTest
class SelectOneTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads() {
        Cust cust = null;
        try {
            service.get("id01");
            log.info("----------------------------");
            log.info(cust.toString());
            log.info("----------------------------");
        } catch (Exception e) {
            log.info("오류");
        }
    }

}
