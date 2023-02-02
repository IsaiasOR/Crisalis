package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.UserRole;
import com.Bootcamp.Crisalis.model.dto.UserDTO;
import com.Bootcamp.Crisalis.model.dto.UserItemDTO;
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
    private String pass;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 15)
    private UserRole userRole;

    @Transient
    private Boolean enabled = Boolean.FALSE;
    @Transient
    private Boolean locked = Boolean.FALSE;

    public User(UserDTO userDTO) {
        this.dni = userDTO.getDni();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.pass = userDTO.getPass();
        this.userRole = userDTO.getUserRole();
    }

    public UserDTO toDTO() {
        return
                UserDTO
                        .builder()
                        .id(this.id)
                        .dni(this.dni)
                        .firstName(this.firstName)
                        .lastName(this.lastName)
                        .email(this.email)
                        .phoneNumber(this.phoneNumber)
                        .pass(this.pass)
                        .userRole(this.userRole)
                        .build();
    }

    public UserItemDTO toItemDTO() {
        return
                UserItemDTO
                        .builder()
                        .id(this.id)
                        .dni(this.dni)
                        .firstName(this.firstName)
                        .lastName(this.lastName)
                        .email(this.email)
                        .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRole());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return pass;
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
