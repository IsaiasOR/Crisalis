package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
//        this.taxes = orderDTO.getTaxes();
    }

    public OrderDTO toDTO() {
        return OrderDTO
                .builder()
                .id(this.id)
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

    /*
    Métodos:
    + aplicarIncrementoPrecioProducto(precio: double, anios: int): void
    + aplicarDescuentoPrecioProducto(valor: double): void
    + asignarServicioACliente(): void
     */
}
