package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessDTO {

    @JsonProperty("BusinnesName")
    private String businessName;

    @JsonProperty("ActStartDate")
    private LocalDate actStartDate;

    @JsonProperty("CUIT")
    private Integer cuit;

    @JsonProperty("Client")
    private HashSet<Client> clients;
}
