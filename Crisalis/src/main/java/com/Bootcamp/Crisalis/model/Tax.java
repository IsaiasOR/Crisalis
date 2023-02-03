package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.TaxDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "tax")
public class Tax {

    @Id
    @SequenceGenerator(
            name = "tax_sequence",
            sequenceName = "tax_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tax_sequence"
    )
    @Column(name = "id_tax")
    private Integer id;

    @Column(name = "nameTax", nullable = false, length = 50)
    private String name;

    @Column(name = "percentage")
    private BigDecimal percentage;

    public Tax(TaxDTO taxDTO) {
        this.name = taxDTO.getName();
        this.percentage = taxDTO.getPercentage();
    }

    public TaxDTO toDTO() {
        return TaxDTO
                .builder()
                .id(this.id)
                .name(this.name)
                .percentage(this.percentage)
                .build();
    }
}
