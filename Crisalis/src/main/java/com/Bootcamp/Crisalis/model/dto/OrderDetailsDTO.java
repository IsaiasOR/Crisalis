package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.Service;
import com.Bootcamp.Crisalis.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("DateCreated")
    private Date dateCreated;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Client")
    private ClientItemDTO client;

    @JsonProperty("Status")
    private Status status;

    @JsonProperty("Products")
    private List<ProductItemDTO> products;

    @JsonProperty("Services")
    private List<ServiceItemDTO> services;

    @JsonProperty("User")
    private UserItemDTO user;
}