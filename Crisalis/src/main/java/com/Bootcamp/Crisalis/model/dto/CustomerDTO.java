package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.enums.ActiveService;
import com.Bootcamp.Crisalis.model.Business;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {

    @JsonProperty("ActiveService")
    private ActiveService activeService;

    @JsonProperty("Firstname")
    private String firstname;

    @JsonProperty("Lastname")
    private String lastname;

    @JsonProperty("DNI")
    private Integer dni;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("PhoneNumber")
    private Integer phoneNumber;

    @JsonProperty("Address")
    private String address;

    //@JsonProperty("Id_Business")
    //private Business idBusiness;
}
