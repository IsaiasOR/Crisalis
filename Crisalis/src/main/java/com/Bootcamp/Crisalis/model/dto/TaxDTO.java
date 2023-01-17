package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Need;
import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.Service;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxDTO {

    @JsonProperty("NameTax")
    private String name;

    @JsonProperty("Percentage")
    private Double percentage;

    @JsonProperty("Products")
    private HashSet<Product> products;

    @JsonProperty("Services")
    private HashSet<Service> services;
}
