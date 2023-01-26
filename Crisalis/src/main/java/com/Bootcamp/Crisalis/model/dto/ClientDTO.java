package com.Bootcamp.Crisalis.model.dto;

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

/*    @JsonProperty("BusinessSet")
    private HashSet<Business> businessSet;

    @JsonProperty("Orders")
    private HashSet<Order> orders;*/
}
