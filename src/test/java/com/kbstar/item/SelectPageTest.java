package com.kbstar.item;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import com.kbstar.service.MarkerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SelectPageTest {
    @Autowired
    ItemService service;
    PageInfo<Item> pageInfo;
    @Test
    void contextLoads() {
        try {
            pageInfo = new PageInfo<>(service.getPage(1), 5); // 5:하단 네비게이션 개수
        } catch (Exception e) {
            log.info("오류");
        }
    }

}
