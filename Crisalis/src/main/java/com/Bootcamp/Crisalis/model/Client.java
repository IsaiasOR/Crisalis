package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.ActiveService;
import com.Bootcamp.Crisalis.model.dto.ClientDTO;
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
@Table(name= "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Client")
    private Integer id;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "DNI")
    private Integer dni;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Address")
    private String address;

    @Column(name = "ActiveService")
    private ActiveService activeService;

    @ManyToMany
    @JoinTable(
            name = "ClientBusiness",
            joinColumns = @JoinColumn(name = "fk_client"),
            inverseJoinColumns = @JoinColumn(name = "fk_business"))
    private List<Business> businessList = new ArrayList<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Client(ClientDTO clientDTO) {
        this.firstname = clientDTO.getFirstname();
        this.lastname = clientDTO.getLastname();
        this.dni = clientDTO.getDni();
        this.email = clientDTO.getEmail();
        this.activeService = clientDTO.getActiveService();
        this.businessList = clientDTO.getBusinessList();
        this.orders = clientDTO.getOrders();
    }

    public ClientDTO toDTO() {
        return ClientDTO
                .builder()
                .firstname(this.firstname)
                .lastname(this.lastname)
                .dni(this.dni)
                .email(this.email)
                .activeService(this.activeService)
                .businessList((ArrayList<Business>) this.businessList)
                .orders((ArrayList<Order>) this.orders)
                .build();
    }
}
