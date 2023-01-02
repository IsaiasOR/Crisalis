package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.NeedDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Need")
@Inheritance(strategy=InheritanceType.JOINED)
public class Need {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Need")
    private Integer id;

    @Column(name = "NameNeed")
    private String name;

    @Column(name = "BaseAmount")
    private Double baseAmount;

    @OneToOne
    @JoinColumn(name = "fk_product")
    private Product product;

    @OneToOne
    @JoinColumn(name = "fk_service")
    private Service service;

    @JoinTable(
            name = "NeedTax",
            joinColumns = @JoinColumn(name = "fk_need", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_tax", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tax> taxes = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "Id_Order")
    private Order order;

    public Need(NeedDTO needDTO) {
        this.name = needDTO.getName();
        this.baseAmount = needDTO.getBaseAmount();
        this.product = needDTO.getProduct();
        this.service = needDTO.getService();
        this.taxes = needDTO.getTaxes();
        this.order = needDTO.getOrder();
    }

    public NeedDTO toDTO() {
        return NeedDTO
                .builder()
                .name(this.name)
                .baseAmount(this.baseAmount)
                .product(this.product)
                .service(this.service)
                .taxes((ArrayList<Tax>) this.taxes)
                .order(this.order)
                .build();
    }
}
