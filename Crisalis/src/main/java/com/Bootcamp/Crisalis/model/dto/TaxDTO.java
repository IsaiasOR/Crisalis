package com.Bootcamp.Crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxDTO {

    @JsonProperty("NameTax")
    private String name;

    @JsonProperty("Percentage")
    private Double percentage;

/*    @JsonProperty("Needs")
    private HashSet<Need> needs;*/

}
