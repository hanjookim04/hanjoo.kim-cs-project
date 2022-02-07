package com.hanjoo.cs.web.domain;

import com.hanjoo.cs.web.type.PraiseType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table(name="praise")
@NoArgsConstructor
@AllArgsConstructor
public class Praise extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private PraiseType praiseType;

    @Column(length = 50, nullable = false)
    private String sender;

    @Column(length = 50, nullable = false)
    private String receiver;

    @Column(length = 500, nullable = false)
    private String praiseMsg;

}
