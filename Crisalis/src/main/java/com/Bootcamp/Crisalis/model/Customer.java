package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.ActiveService;
import com.Bootcamp.Crisalis.model.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Customer")
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
    private Integer phoneNumber;

    @Column(name = "Address")
    private String address;

    @Column(name = "ActiveService")
    private ActiveService activeService;

    /*
    @Column(name = "Id_Business")
    private Business idBusiness;
    */

    public Customer(CustomerDTO customerDTO) {
        this.firstname = customerDTO.getFirstname();
        this.lastname = customerDTO.getLastname();
        this.dni = customerDTO.getDni();
        this.email = customerDTO.getEmail();
        this.phoneNumber = customerDTO.getPhoneNumber();
        this.address = customerDTO.getAddress();
        this.activeService = customerDTO.getActiveService();
        //this.idBusiness = customerDTO.getIdBusiness();
    }

    public CustomerDTO toDTO() {
        return CustomerDTO
                .builder()
                .firstname(this.firstname)
                .lastname(this.lastname)
                .dni(this.dni)
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .activeService(this.activeService)
                //.idBusiness(this.idBusiness)
                .build();
    }
}
