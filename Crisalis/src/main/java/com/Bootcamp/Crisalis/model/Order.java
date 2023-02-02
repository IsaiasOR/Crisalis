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
    private Date dateCreated;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

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

    @OneToMany(
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();

    @OneToMany(
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    private Set<Service> services = new HashSet<>();

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "id_client")
    @ToString.Exclude
    private Client client;

//    @OneToMany(
//            fetch = FetchType.EAGER
//    )
//    @ToString.Exclude
//    private Set<Tax> taxes = new HashSet<>();

    //@Transient
    //private final static int TOP_DISCOUNT = 0;
    //¿Garantia en años?
    //@Transient
    //private int quantity;

    public Order(OrderDTO orderDTO) {
        this.dateCreated = orderDTO.getDateCreated();
        this.amount = orderDTO.getAmount();
        this.description = orderDTO.getDescription();
        this.user = orderDTO.getUser();
        this.products = orderDTO.getProducts();
        this.services = orderDTO.getServices();
        this.client = orderDTO.getClient();
        this.status = orderDTO.getStatus();
//        this.taxes = orderDTO.getTaxes();
    }

    public OrderDTO toDTO() {
        return OrderDTO
                .builder()
                .dateCreated(this.dateCreated)
                .amount(this.amount)
                .description(this.description)
                .user(this.user)
                .products(this.products)
                .services(this.services)
                .client(this.client)
//                .taxes(this.taxes)
                .build();
    }

    public OrderItemDTO toOrderItemDTO() {
        return OrderItemDTO
                .builder()
                .id(this.id)
                .amount(this.amount)
                .description(this.description)
                .client(this.client.getDni())
                .status(this.status)
                .build();
    }

    public OrderDetailsDTO toOrderDetailsDTO() {
        return OrderDetailsDTO
                .builder()
                .id(this.id)
                .amount(this.amount)
                .description(this.description)
                .client(this.client.toCLientItemDTO())
                .status(this.status)
                .products(this.products.stream().map(Product::toItemDTO).collect(Collectors.toList()))
                .services(this.services.stream().map(Service::toServiceItemDTO).collect(Collectors.toList()))
                .user(this.user.toItemDTO())
                .status(this.status)
                .build();
    }

    /*
    Métodos:
    + aplicarIncrementoPrecioProducto(precio: double, anios: int): void
    + aplicarDescuentoPrecioProducto(valor: double): void
    + asignarServicioACliente(): void
     */
}
