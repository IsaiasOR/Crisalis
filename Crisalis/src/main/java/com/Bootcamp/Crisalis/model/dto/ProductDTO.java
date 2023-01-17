package com.Bootcamp.Crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO extends NeedDTO {

    @JsonProperty("Guarantee")
    private Integer guarantee;

   /* @JsonProperty("Order")
    private Order order;

    @JsonProperty("Taxes")
    private HashSet<Tax> taxes;
*/
/*    @JsonProperty("Need")
    private Need need;*/
}
