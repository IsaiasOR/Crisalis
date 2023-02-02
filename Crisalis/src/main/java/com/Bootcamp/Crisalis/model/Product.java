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
@AllArgsConstructor
@Entity
@DiscriminatorValue("Product")
public class Product extends Need {

    @Column(name = "guarantee")
    private Integer guarantee;

    @Column(name = "status")
    private Status status;

    public Product(ProductDTO productDTO) {
        super(productDTO);
        this.guarantee = productDTO.getGuarantee();
    }

    public ProductDTO toDTO() {
        return ProductDTO
                .builder()
                .id(this.getId())
                .name(this.getName())
                .baseAmount(this.getBaseAmount())
                .taxes(this.getTaxes())
                .status(this.getStatus())
                .guarantee(this.guarantee)
                .build();
    }

    public ProductItemDTO toItemDTO() {
        return ProductItemDTO
                .builder()
                .id(this.getId())
                .name(this.getName())
                .baseAmount(this.getBaseAmount())
                .status(this.getStatus())
                .build();
    }
}
