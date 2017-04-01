package com.github.ystromm.learn_spring_contract.frontend.dtos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;


@Data
@Builder
@Setter(AccessLevel.NONE)
public class EventDTO {
    private UUID id;
    private Instant start;
    private String description;
    private String speaker;
    private String location;
}
