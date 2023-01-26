package com.Bootcamp.Crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessDTO {

    @JsonProperty("BusinessName")
    private String businessName;

    @JsonProperty("ActStartDate")
    private LocalDate actStartDate;

    @JsonProperty("CUIT")
    private Integer cuit;

/*    @JsonProperty("Client")
    private HashSet<Client> clients;*/
}
