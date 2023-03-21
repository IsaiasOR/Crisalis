package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.model.dto.*;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "orders")
public class Order {

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
    @Column(name = "id_order")
    private Integer id;

    @Column(name = "dateOrder", nullable = false)
    private String dateCreated;

    @Column(name = "totalAmount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Status status;

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "id_user")
    @ToString.Exclude
    private User user;

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "id_client")
    @ToString.Exclude
    private Client client;

    @OneToMany(
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    private Set<OrderDetails> orderDetails = new HashSet<>();

    public Order(OrderDTO orderDTO) {
        this.dateCreated = orderDTO.getDateCreated();
        this.totalAmount = orderDTO.getTotalAmount();
        this.description = orderDTO.getDescription();
        this.user = orderDTO.getUser();
        this.client = orderDTO.getClient();
        this.status = orderDTO.getStatus();
        this.orderDetails = orderDTO.getOrderDetails();
    }

    public OrderDTO toDTO() {
        return OrderDTO
                .builder()
                .dateCreated(this.dateCreated)
                .totalAmount(this.totalAmount)
                .description(this.description)
                .user(this.user)
                .client(this.client)
                .orderDetails(this.orderDetails)
                .build();
    }
}
