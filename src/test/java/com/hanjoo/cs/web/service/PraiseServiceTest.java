package com.hanjoo.cs.web.service;

import com.hanjoo.cs.web.domain.Praise;
import com.hanjoo.cs.web.dto.PageRequestDTO;
import com.hanjoo.cs.web.dto.PageResultDTO;
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

    @Test
    public void testPraiseList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<PraiseDTO, Praise> pageResultDTO = praiseService.getPraiseList(pageRequestDTO);

        System.out.println("[PREV]"+ pageResultDTO.isPrev());
        System.out.println("[NEXT]"+ pageResultDTO.isNext());
        System.out.println("[TOTAL]"+ pageResultDTO.getTotalPage());
        for(PraiseDTO praiseDTO : pageResultDTO.getDtoList()){
            System.out.println(praiseDTO);
        }

        System.out.println("page info");
        pageResultDTO.getPageList().forEach(i-> System.out.println(i));

    }
}