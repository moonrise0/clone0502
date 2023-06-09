package com.kbstar.item;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.service.CustService;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UpdateTest {
    @Autowired
    ItemService service;
    @Test
    void contextLoads() {
        try {
            service.modify(new Item(101,"모자2",20000,"hat.jpg",null));
            service.get(101);
        } catch (Exception e) {
            log.info("오류");
        }

    }

}
