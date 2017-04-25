package com.github.ystromm.learn_spring_contract.backend.repository;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Setter(AccessLevel.NONE)
@Builder
public class EventEntity {
    private int id;
    private String title;
    private String description;
    private String speaker;
    private String location;
    private LocalDateTime start;
    private Duration length;

}
