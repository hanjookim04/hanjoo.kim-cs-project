package com.hanjoo.cs.web.dto;


import com.hanjoo.cs.web.type.PraiseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PraiseDTO {
    private Long id;

    private PraiseType praiseType;

    private String sender;

    private String receiver;

    private String praiseMsg;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
