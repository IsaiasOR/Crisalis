package com.Bootcamp.Crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO extends NeedDTO {

    @JsonProperty("MonthlyCost")
    private BigDecimal monthlyCost;

    @JsonProperty("SupportChange")
    private BigDecimal supportChange;

    /*@JsonProperty("Order")
    private Order order;

    @JsonProperty("Taxes")
    private HashSet<Tax> taxes;*/

/*    @JsonProperty("Need")
    private Need need;*/
}
