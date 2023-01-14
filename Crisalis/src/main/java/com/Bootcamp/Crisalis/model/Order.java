package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.OrderDTO;
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
            allocationSize = 1,
            initialValue = 1
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
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(name = "id_user")
    @ToString.Exclude
    private User user;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
    private Set<Need> needs = new HashSet<>();

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(name = "id_client")
    @ToString.Exclude
    private Client client;

    //@Transient
    //private final static int TOP_DISCOUNT = 0;
    //¿Garantia en años?
    //@Transient
    //private int quantity;

    public Order(OrderDTO orderDTO) {
        this.dateCreated = orderDTO.getDateCreated();
        this.amount = orderDTO.getAmount();
        this.user = orderDTO.getUser();
        this.needs = orderDTO.getNeeds();
        this.client = orderDTO.getClient();
    }

    public OrderDTO toDTO() {
        return OrderDTO
                .builder()
                .dateCreated(this.dateCreated)
                .amount(this.amount)
                .user(this.user)
                .needs((HashSet<Need>) this.needs)
                .client(this.client)
                .build();
    }

    /*
    Métodos:
    + aplicarIncrementoPrecioProducto(precio: double, anios: int): void
    + aplicarDescuentoPrecioProducto(valor: double): void
    + asignarServicioACliente(): void
     */
}
