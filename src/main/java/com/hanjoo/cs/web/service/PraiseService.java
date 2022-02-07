package com.hanjoo.cs.web.service;


import com.hanjoo.cs.web.domain.Praise;
import com.hanjoo.cs.web.dto.PraiseDTO;
import com.hanjoo.cs.web.repository.PraiseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PraiseService {

    private final PraiseRepository praiseRepository;


    public long registerPraise(PraiseDTO praiseDTO){

        log.info("[PraiseService] registerPraise entering...");

        log.info(praiseDTO);

        Praise praise = dtoToEntity(praiseDTO);

        log.info(praise);

        praiseRepository.save(praise);

        log.info("[praise.id]"+ praise.getId());

        return praise.getId();

    }


    PraiseDTO entityToDto(Praise praise){

        PraiseDTO praiseDTO = PraiseDTO.builder()
                .id(praise.getId())
                .receiver(praise.getReceiver())
                .sender(praise.getSender())
                .praiseType(praise.getPraiseType())
                .praiseMsg(praise.getPraiseMsg())
                .createdAt(praise.getCreatedAt())
                .updatedAt(praise.getUpdatedAt())
                .build();

        return praiseDTO;

    }


    Praise dtoToEntity(PraiseDTO dto){



        Praise entity = Praise.builder()
                .id(dto.getId())
                .receiver(dto.getReceiver())
                .sender(dto.getSender())
                .praiseType(dto.getPraiseType())
                .praiseMsg(dto.getPraiseMsg())
                .build();

        return entity;
    }
}
