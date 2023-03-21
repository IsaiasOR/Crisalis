package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.model.*;
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
public class OrderDTO {

    @JsonProperty("DateCreated")
    private String dateCreated;

    @JsonProperty("TotalAmount")
    private BigDecimal totalAmount;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Client")
    private Client client;

    @JsonProperty("User")
    private User user;

    @JsonProperty("Status")
    private Status status;

    @JsonProperty("OrderDetails")
    private Set<OrderDetails> orderDetails = new HashSet<>();

}
