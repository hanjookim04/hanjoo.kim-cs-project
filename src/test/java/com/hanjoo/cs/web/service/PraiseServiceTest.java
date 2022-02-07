package com.hanjoo.cs.web.service;

import com.hanjoo.cs.web.dto.PraiseDTO;
import com.hanjoo.cs.web.type.PraiseType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PraiseServiceTest {

    @Autowired
    private PraiseService praiseService;

    @Test
    void registerPraise() {
        PraiseDTO dto = PraiseDTO.builder()
                .sender("TestSender")
                .receiver("TestReceiver")
                .praiseType(PraiseType.HELPFUL)
                .praiseMsg("priaseMessage")
                .build();

        System.out.println(praiseService.registerPraise(dto));
    }
}