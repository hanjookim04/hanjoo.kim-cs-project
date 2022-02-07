package com.hanjoo.cs.web.repository;

import com.hanjoo.cs.web.domain.Praise;
import com.hanjoo.cs.web.type.PraiseType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PraiseRepositoryTest {

    @Autowired
    PraiseRepository praiseRepository;


    @Test
    public void insertOne(){
        Praise praise = Praise.builder()
                .sender("sender")
                .receiver("receiver")
                .praiseMsg("message")
                .praiseType(PraiseType.GOODJOB)
                .build()
                ;
        praiseRepository.save(praise);
    }

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Praise praise = Praise.builder()
                    .sender(i+":sender")
                    .receiver(i+":receiver")
                    .praiseMsg(i+":message")
                    .praiseType(PraiseType.GOODJOB)
                    .build();

            praiseRepository.save(praise);
        });
    }
}