package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.TaxDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Tax")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Tax")
    private Integer id;

    @Column(name = "NameTax")
    private String nameTax;

    @Column(name = "Amount")
    private Double amount;

    @ManyToMany(mappedBy = "taxes")
    private List<Need> needs = new ArrayList<>();

    public Tax(TaxDTO taxDTO) {
        this.nameTax = taxDTO.getNameTax();
        this.amount = taxDTO.getAmount();
        this.needs = taxDTO.getNeeds();
    }

    public TaxDTO toDTO() {
        return TaxDTO
                .builder()
                .nameTax(this.nameTax)
                .amount(this.amount)
                .needs((ArrayList<Need>) this.needs)
                .build();
    }
}
