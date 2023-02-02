package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    @JsonProperty("DateCreated")
    private String dateCreated;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("User")
    private User user;

    @JsonProperty("Products")
    private Set<Product> products;

    @JsonProperty("Services")
    private Set<Service> services;

    @JsonProperty("Client")
    private Client client;

    @JsonProperty("Status")
    private Status status;
}
