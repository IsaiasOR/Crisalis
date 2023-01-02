package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessDTO {

    @JsonProperty("BusinnesName")
    private String businessName;

    @JsonProperty("ActStartDate")
    private LocalDateTime actStartDate;

    @JsonProperty("CUIT")
    private Integer cuit;

    @JsonProperty("Client")
    private ArrayList<Client> clients;
}
