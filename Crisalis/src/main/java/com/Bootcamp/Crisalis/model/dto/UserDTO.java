package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    @JsonProperty("DNI")
    private Integer dni;

    //Desde el font-end viene como "Nombre" y aquí se lo mapea y se lo trabaja como firstName
    @JsonProperty("Firstname")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("PhoneNumber")
    private Integer phoneNumber;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Role")
    private UserRole userRole;
}
