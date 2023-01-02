package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Need;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxDTO {

    @JsonProperty("NameTax")
    private String nameTax;

    @JsonProperty("Amount")
    private Double amount;

    @JsonProperty("Needs")
    private ArrayList<Need> needs;
}
