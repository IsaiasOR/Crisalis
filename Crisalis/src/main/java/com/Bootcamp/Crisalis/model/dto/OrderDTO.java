package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    @JsonProperty("DateOrder")
    private Date dateCreated;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Id_User")
    private User user;

    @JsonProperty("Product")
    private HashSet<Product> products;

    @JsonProperty("Need")
    private HashSet<Service> services;

    @JsonProperty("Id_Client")
    private Client client;
}
