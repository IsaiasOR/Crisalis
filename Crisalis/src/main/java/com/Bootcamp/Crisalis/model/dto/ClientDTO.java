package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Business;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("ActiveService")
    private Boolean activeService;

    @JsonProperty("FirstName")
    private String firstname;

    @JsonProperty("LastName")
    private String lastname;

    @JsonProperty("DNI")
    private Integer dni;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @JsonProperty("Business")
    private Business business;
}
