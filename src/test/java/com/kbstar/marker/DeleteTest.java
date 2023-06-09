package com.kbstar.marker;

import com.kbstar.service.CustService;
import com.kbstar.service.MarkerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DeleteTest {
    @Autowired
    MarkerService service;
    @Test
    void contextLoads() {
         try {
            service.remove(109);
            service.getall();
        } catch (Exception e) {
             log.info("오류");
         }
    }

}
