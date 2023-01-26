package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.Tax;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.HashSet;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NeedDTO {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("BaseAmount")
    private BigDecimal baseAmount;

/*    @JsonProperty("Taxes")
    private HashSet<Tax> taxes;

    @JsonProperty("Order")
    private Order order;*/
}
