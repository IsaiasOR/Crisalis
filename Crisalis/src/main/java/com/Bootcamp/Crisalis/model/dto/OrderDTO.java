package com.Bootcamp.Crisalis.model.dto;

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
public class OrderDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("DateCreated")
    private Date dateCreated;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("Description")
    private String description;

/*    @JsonProperty("User")
    private User user;*/

/*    @JsonProperty("Products")
    private HashSet<Product> products;

    @JsonProperty("Services")
    private HashSet<Service> services;

    @JsonProperty("Client")
    private Client client;*/
}
