package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.model.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("DateCreated")
    private Date dateCreated;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Client")
    private Integer client;

    @JsonProperty("Status")
    private Status status;
}
