package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Product")
@PrimaryKeyJoinColumn(name="Id_Need")
public class Product extends Need {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Product")
    private Integer id;

    @Column(name = "Guarantee")
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
