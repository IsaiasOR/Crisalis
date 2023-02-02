package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.enums.TypeService;
import com.Bootcamp.Crisalis.model.Tax;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceItemDTO extends NeedDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("BaseAmount")
    private BigDecimal baseAmount;

    @JsonProperty("TypeService")
    private TypeService typeService;

    @JsonProperty("Status")
    private Status status;
}