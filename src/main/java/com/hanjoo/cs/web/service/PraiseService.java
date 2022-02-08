package com.hanjoo.cs.web.service;


import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.hanjoo.cs.web.domain.Praise;
import com.hanjoo.cs.web.dto.PageRequestDTO;
import com.hanjoo.cs.web.dto.PageResultDTO;
import com.hanjoo.cs.web.dto.PraiseDTO;
import com.hanjoo.cs.web.repository.PraiseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

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

    /**
     * praise detail info
     * @param id
     * @return
     */
    public PraiseDTO getPraiseDetail(Long id){
        Optional<Praise> result = praiseRepository.findById(id);

        return result.isPresent()?entityToDto(result.get()):null;
    }


    /**
     * modify praise
     * @return
     */
    public void modifyPraise(PraiseDTO praiseDTO){
        Optional<Praise> result = praiseRepository.findById(praiseDTO.getId());

        if(result.isPresent()){
            Praise praise = result.get();

            praise.setSender(praiseDTO.getSender());
            praise.setReceiver(praiseDTO.getReceiver());
            praise.setPraiseType(praiseDTO.getPraiseType());
            praise.setPraiseMsg(praiseDTO.getPraiseMsg());

            praiseRepository.save(praise);
        }
    }



    public PageResultDTO<PraiseDTO, Praise> getPraiseList(PageRequestDTO pageRequestDTO){

        Pageable pageable = pageRequestDTO.getPageable(Sort.by("id").descending());

        Page<Praise> result = praiseRepository.findAll(pageable);
        Function<Praise, PraiseDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);

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
