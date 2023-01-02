package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Order")
    private Integer id;

    @Column(name = "DateOrder")
    private LocalDateTime dateOrder;

    @Column(name = "Amount")
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_User")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<Need> needs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Client")
    private Client client;

    //@Transient
    //private final static int TOP_DISCOUNT = 0;
    //¿Garantia en años?
    //@Transient
    //private int quantity;

    public Order(OrderDTO orderDTO) {
        this.dateOrder = orderDTO.getDateOrder();
        this.amount = orderDTO.getAmount();
        this.user = orderDTO.getUser();
        this.needs = orderDTO.getNeeds();
        this.client = orderDTO.getClient();
    }

    public OrderDTO toDTO() {
        return OrderDTO
                .builder()
                .dateOrder(this.dateOrder)
                .amount(this.amount)
                .user(this.user)
                .needs((ArrayList<Need>) this.needs)
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
