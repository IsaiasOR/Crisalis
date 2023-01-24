package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.UserRole;
import com.Bootcamp.Crisalis.model.dto.UserDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "users")
public class User implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "dni", nullable = false)
    private Integer dni;

    @Column(name = "firstname", nullable = false, length = 25)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 25)
    private String lastName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phoneNumber", length = 25)
    private String phoneNumber;

    @Column(name = "pass", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 15)
    private UserRole userRole;

    @Transient
    private Boolean enabled = Boolean.FALSE;
    @Transient
    private Boolean locked = Boolean.FALSE;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Order> orders = new HashSet<>();

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
                        .orders((HashSet<Order>) this.orders)
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
