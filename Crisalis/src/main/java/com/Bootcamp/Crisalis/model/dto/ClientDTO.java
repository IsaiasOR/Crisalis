package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.ActiveService;
import com.Bootcamp.Crisalis.model.Business;
import com.Bootcamp.Crisalis.model.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {

    @JsonProperty("ActiveService")
    private ActiveService activeService;

    @JsonProperty("Firstname")
    private String firstname;

    @JsonProperty("Lastname")
    private String lastname;

    @JsonProperty("DNI")
    private Integer dni;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Business list")
    private ArrayList<Business> businessList;

    @JsonProperty("Orders")
    private ArrayList<Order> orders;
}
