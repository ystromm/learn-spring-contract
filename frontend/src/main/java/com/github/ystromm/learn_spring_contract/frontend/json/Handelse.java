package com.github.ystromm.learn_spring_contract.frontend.json;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Setter(AccessLevel.NONE)

public class Handelse {
    private int id;
    private String beskrivning;
    private String talare;
    private String plats;
}
