package com.github.ystromm.learn_spring_contract.frontend.json;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
@Builder
@Setter(AccessLevel.NONE)
public class Event {
    private int id;
    private String description;
    private String speaker;
    private String location;
    private LocalDateTime start;
}
