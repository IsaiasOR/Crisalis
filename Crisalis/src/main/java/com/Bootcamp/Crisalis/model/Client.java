package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.ClientDTO;
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
@Table(name= "Clients")
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    @Column(name = "id_client")
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 25)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 25)
    private String lastname;

    @Column(name = "dni", nullable = false)
    private Integer dni;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "phoneNumber", length = 25)
    private String phoneNumber;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "activeService", nullable = false)
    private Boolean activeService;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_business")
    @ToString.Exclude
    private Business business;

//    @OneToMany(
//            mappedBy = "client",
//            fetch = FetchType.LAZY
//    )
//    @ToString.Exclude
//    private Set<Order> orders = new HashSet<>();

    public Client(ClientDTO clientDTO) {
        this.firstname = clientDTO.getFirstname();
        this.lastname = clientDTO.getLastname();
        this.dni = clientDTO.getDni();
        this.email = clientDTO.getEmail();
        this.activeService = clientDTO.getActiveService();
        this.address = clientDTO.getAddress();
        this.phoneNumber = clientDTO.getPhoneNumber();
        this.business = clientDTO.getBusiness();
//        this.orders = clientDTO.getOrders();
    }

    public ClientDTO toDTO() {
        return ClientDTO
                .builder()
                .id(this.id)
                .firstname(this.firstname)
                .lastname(this.lastname)
                .dni(this.dni)
                .email(this.email)
                .activeService(this.activeService)
                .address(this.address)
                .phoneNumber(this.phoneNumber)
                .business(this.business)
//                .orders(this.orders)
                .build();
    }
}
