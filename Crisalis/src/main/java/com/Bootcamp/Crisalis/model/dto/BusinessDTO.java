package com.Bootcamp.Crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BusinessDTO {

    @JsonProperty("BusinnesName")
    private String businessName;

    @JsonProperty("ActStartDate")
    private LocalDateTime actStartDate;

    @JsonProperty("CUIT")
    private Integer cuit;
}
