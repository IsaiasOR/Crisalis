package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    //Desde el font-end viene como "Nombre" y aquí se lo mapea y se lo trabaja como firstName
    @JsonProperty("Nombre")
    private String firstName;

    @JsonProperty("Apellido")
    private String lastName;

    @JsonProperty("Usuario")
    private String username;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Contraseña")
    private String password;

    @JsonProperty("Rol")
    private UserRole userRole;
}
