package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.OrderDetailsDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "orders_details")
public class OrderDetails {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(name = "id_order_details")
    private Integer id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "guarantee")
    private Integer guarantee;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    private Product product;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    private Service service;

    @OneToMany(
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    private Set<Tax> taxes = new HashSet<>();

    public OrderDetails(OrderDetailsDTO orderDetailsDTO) {
        this.amount = orderDetailsDTO.getAmount();
        this.description = orderDetailsDTO.getDescription();
        this.service = orderDetailsDTO.getService();
        this.product = orderDetailsDTO.getProduct();
        this.quantity = orderDetailsDTO.getQuantity();
        this.guarantee = orderDetailsDTO.getGuarantee();
        this.taxes = orderDetailsDTO.getTaxes();
    }

    public OrderDetailsDTO toOrderDetailsDTO() {
        return OrderDetailsDTO
                .builder()
                .id(this.id)
                .amount(this.amount)
                .description(this.description)
                .service(this.service)
                .product(this.product)
                .quantity(this.quantity)
                .guarantee(this.guarantee)
                .taxes(this.taxes)
                .build();
    }
}