package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.ProductDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "product")
@PrimaryKeyJoinColumn(name="id_need")
public class Product extends Need {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "id_product")
    private Integer id;

    @Column(name = "guarantee")
    private Integer guarantee;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Need need;


    public Product(ProductDTO productDTO) {
        this.guarantee = productDTO.getGuarantee();
        this.need = productDTO.getNeed();
    }

    public ProductDTO toDTO() {
        return ProductDTO
                .builder()
                .guarantee(this.guarantee)
                .need(this.need)
                .build();
    }

}
