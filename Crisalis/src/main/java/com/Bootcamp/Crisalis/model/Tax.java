package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.TaxDTO;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tax_sequence"
    )
    @Column(name = "id_tax")
    private Integer id;

    @Column(name = "nameTax", nullable = false, length = 50)
    private String name;

    @Column(name = "amount")
    private Double amount;

    @ManyToMany(mappedBy = "taxes", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Need> needs = new HashSet<>();

    public Tax(TaxDTO taxDTO) {
        this.name = taxDTO.getName();
        this.amount = taxDTO.getAmount();
        this.needs = taxDTO.getNeeds();
    }

    public TaxDTO toDTO() {
        return TaxDTO
                .builder()
                .name(this.name)
                .amount(this.amount)
                .needs((HashSet<Need>) this.needs)
                .build();
    }
}
