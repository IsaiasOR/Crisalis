package com.Bootcamp.Crisalis.model.dto;

import com.Bootcamp.Crisalis.model.Client;
import com.Bootcamp.Crisalis.model.Need;
import com.Bootcamp.Crisalis.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    @JsonProperty("DateOrder")
    private LocalDateTime dateOrder;

    @JsonProperty("Amount")
    private Double amount;

    @JsonProperty("Id_User")
    private User user;

    @JsonProperty("Need")
    private ArrayList<Need> needs;

    @JsonProperty("Id_Client")
    private Client client;
}
