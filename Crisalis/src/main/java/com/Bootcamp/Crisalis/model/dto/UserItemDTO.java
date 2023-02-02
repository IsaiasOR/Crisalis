package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserItemDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("DNI")
    private Integer dni;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Email")
    private String email;
}
