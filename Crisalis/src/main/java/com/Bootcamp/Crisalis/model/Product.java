package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.model.dto.ProductDTO;
import com.Bootcamp.Crisalis.model.dto.ProductItemDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@DiscriminatorValue("Product")
public class Product extends Need {

    public Product(ProductDTO productDTO) {
        super(productDTO);
    }

    public ProductDTO toDTO() {
        return ProductDTO
                .builder()
                .id(this.getId())
                .name(this.getName())
                .baseAmount(this.getBaseAmount())
                .build();
    }

    public ProductItemDTO toItemDTO() {
        return ProductItemDTO
                .builder()
                .id(this.getId())
                .name(this.getName())
                .baseAmount(this.getBaseAmount())
                .build();
    }
}
