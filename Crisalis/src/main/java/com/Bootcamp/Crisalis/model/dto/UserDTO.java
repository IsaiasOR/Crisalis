package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.UserRole;
import com.Bootcamp.Crisalis.model.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @JsonProperty("DNI")
    private Integer dni;

    @JsonProperty("Firstname")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Role")
    private UserRole userRole;

    @JsonProperty("Orders")
    private ArrayList<Order> orders;
}
