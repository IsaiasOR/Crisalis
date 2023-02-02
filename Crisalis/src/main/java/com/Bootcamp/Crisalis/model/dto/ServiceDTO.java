package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.enums.TypeService;
import com.Bootcamp.Crisalis.model.Tax;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO extends NeedDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("BaseAmount")
    private BigDecimal baseAmount;

    @JsonProperty("MonthlyCost")
    private BigDecimal monthlyCost;

    @JsonProperty("SupportChange")
    private BigDecimal supportChange;

    @JsonProperty("TypeService")
    private TypeService typeService;

    @JsonProperty("Taxes")
    private Set<Tax> taxes;

}
