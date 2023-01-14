package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.NeedDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name= "need")
@Inheritance(strategy=InheritanceType.JOINED)
public class Need {

    @Id
    @SequenceGenerator(
            name = "need_sequence",
            sequenceName = "need_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "need_sequence"
    )
    @Column(name = "id_need")
    private Integer id;

    @Column(name = "nameNeed", nullable = false, length = 50)
    private String name;

    @Column(name = "baseAmount")
    private BigDecimal baseAmount;

    @OneToOne
    @JoinColumn(name = "fk_product")
    private Product product;

    @OneToOne
    @JoinColumn(name = "fk_service")
    private Service service;

    @JoinTable(
            name = "needTax",
            joinColumns = @JoinColumn(name = "fk_need"),
            inverseJoinColumns = @JoinColumn(name="fk_tax")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Tax> taxes = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    @ToString.Exclude
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
                .taxes((HashSet<Tax>) this.taxes)
                .order(this.order)
                .build();
    }
}
