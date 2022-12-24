package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.UserRole;
import com.Bootcamp.Crisalis.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Users")
public class User implements UserDetails {

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

    @Column(name = "PhoneNumber")
    private Integer phoneNumber;

    @Column(name = "Pass")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private UserRole userRole;

    private Boolean locked = false;
    private Boolean enabled = false;

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
        this.phoneNumber = userDTO.getPhoneNumber();
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
                        .phoneNumber(this.phoneNumber)
                        .password(this.password)
                        .userRole(this.userRole)
                        .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.returnRole());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
