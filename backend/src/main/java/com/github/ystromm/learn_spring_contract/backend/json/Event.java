package com.github.ystromm.learn_spring_contract.backend.json;

import lombok.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
@Setter(AccessLevel.NONE)
public class Event {
    private int id;
    private String description;
    private String speaker;
    private String location;
}
