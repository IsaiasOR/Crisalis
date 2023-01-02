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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phonenumber")
    private String phoneNumber;

    @Column(name = "Pass")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private UserRole userRole;

    @Transient
    private Boolean enabled = Boolean.FALSE;
    @Transient
    private Boolean locked = Boolean.FALSE;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

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
        this.orders = userDTO.getOrders();
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
                        .orders((ArrayList<Order>) this.orders)
                        .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.returnRole());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
