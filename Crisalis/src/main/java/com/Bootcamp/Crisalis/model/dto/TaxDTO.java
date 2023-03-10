package com.Bootcamp.Crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("NameTax")
    private String name;

    @JsonProperty("Percentage")
    private BigDecimal percentage;

/*    @JsonProperty("Needs")
    private HashSet<Need> needs;*/

}
