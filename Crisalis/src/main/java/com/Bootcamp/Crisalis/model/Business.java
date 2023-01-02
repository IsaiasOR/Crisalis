package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.BusinessDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Business")
    private Integer id;

    @Column(name = "BusinessName")
    private String businessName;

    @Column(name = "ActStartDate")
    private LocalDateTime actStartDate;

    @Column(name = "CUIT")
    private Integer cuit;

    @ManyToMany(mappedBy = "businessList")
    private List<Client> clients = new ArrayList<>();

    public Business(BusinessDTO businessDTO) {
        this.businessName = businessDTO.getBusinessName();
        this.actStartDate = businessDTO.getActStartDate();
        this.cuit = businessDTO.getCuit();
        this.clients = businessDTO.getClients();
    }

    public BusinessDTO toDTO() {
        return BusinessDTO
                .builder()
                .businessName(this.businessName)
                .actStartDate(this.actStartDate)
                .cuit(this.cuit)
                .clients((ArrayList<Client>) this.clients)
                .build();
    }
}
