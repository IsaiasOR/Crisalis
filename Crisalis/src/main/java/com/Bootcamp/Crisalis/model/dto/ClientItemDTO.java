package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Business;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientItemDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("FirstName")
    private String firstname;

    @JsonProperty("LastName")
    private String lastname;

    @JsonProperty("DNI")
    private Integer dni;

    @JsonProperty("ActiveService")
    private Boolean activeService;

    @JsonProperty("Business")
    private String business;
}