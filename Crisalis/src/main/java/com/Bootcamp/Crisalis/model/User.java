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
@Table(name= "Usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuario")
    private Integer id;

    @Column(name = "Nombre")
    private String firstName;

    @Column(name = "Apellido")
    private String lastName;

    @Column(name = "Usuario")
    private String username;

    @Column(name = "Email")
    private String email;

    @Column(name = "Contraseña")
    private String password;

    @Column(name = "Role")
    private UserRole userRole;

    /*
    Otra opción para esto es:
    1. Mapear en otra clase, es decir que reciba cierta cantidad de cosas y nosotros
    lo mapeamos a lo que necesitemos (dependerá de cuánto tendremos que mapear)
    2. Utilizar builder en vez de @NoArgsConstructor
     */
    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.username = userDTO.getUsername();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.userRole = userDTO.getUserRole();
    }

    public UserDTO toDTO() {
        return
                UserDTO
                        .builder()
                        .firstName(this.firstName)
                        .lastName(this.lastName)
                        .username(this.username)
                        .email(this.email)
                        .password(this.password)
                        .build();
    }
}
