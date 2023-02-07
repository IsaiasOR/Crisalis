package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.Service;
import com.Bootcamp.Crisalis.model.Tax;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Products")
    private Product product;

    @JsonProperty("Quantity")
    private Integer quantity;

    @JsonProperty("Guarantee")
    private Integer guarantee;

    @JsonProperty("Services")
    private Service service;

    @JsonProperty("Taxes")
    private Set<Tax> taxes = new HashSet<>();

}