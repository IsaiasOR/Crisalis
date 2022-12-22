package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.UserRole;
import com.Bootcamp.Crisalis.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_User")
    private Integer id;

    @Column(name = "DNI")
    private Integer dni;

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "MobileNumberPhone")
    private Integer numberPhone;

    @Column(name = "Pass")
    private String password;

    @Column(name = "UserRole")
    private UserRole userRole;

    /*
    Otra opción para esto es:
    1. Mapear en otra clase, es decir que reciba cierta cantidad de cosas y nosotros
    lo mapeamos a lo que necesitemos (dependerá de cuánto tendremos que mapear)
    2. Utilizar builder en vez de @NoArgsConstructor
     */
    public User(UserDTO userDTO) {
        this.dni = userDTO.getDni();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.numberPhone = userDTO.getNumberPhone();
        this.password = userDTO.getPassword();
        this.userRole = userDTO.getUserRole();
    }

    public UserDTO toDTO() {
        return
                UserDTO
                        .builder()
                        .dni(this.dni)
                        .firstName(this.firstName)
                        .lastName(this.lastName)
                        .email(this.email)
                        .numberPhone(this.numberPhone)
                        .password(this.password)
                        .userRole(this.userRole)
                        .build();
    }
}
