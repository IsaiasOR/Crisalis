package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.Service;
import com.Bootcamp.Crisalis.model.Tax;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NeedDTO {

    @JsonProperty("NameNeed")
    private String name;

    @JsonProperty("BaseAmount")
    private Double baseAmount;

    @JsonProperty("Product")
    private Product product;

    @JsonProperty("Service")
    private Service service;

    @JsonProperty("Service")
    private ArrayList<Tax> taxes;

    @JsonProperty("Order")
    private Order order;
}
