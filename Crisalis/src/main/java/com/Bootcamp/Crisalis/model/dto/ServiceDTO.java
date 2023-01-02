package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Need;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO extends NeedDTO {

    @JsonProperty("MonthlyCost")
    private Double monthlyCost;

    @JsonProperty("SupportChange")
    private Double supportChange;

    @JsonProperty("Need")
    private Need need;
}
