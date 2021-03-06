package com.github.ystromm.learn_spring_contract.backend.json;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Setter(AccessLevel.NONE)
public class Event {
    private int id;
    private String description;
    private String speaker;
    private String location;
}
