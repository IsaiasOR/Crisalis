package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.BusinessDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public Business(BusinessDTO businessDTO) {
        this.businessName = businessDTO.getBusinessName();
        this.actStartDate = businessDTO.getActStartDate();
        this.cuit = businessDTO.getCuit();
    }

    public BusinessDTO toDTO() {
        return BusinessDTO
                .builder()
                .businessName(this.businessName)
                .actStartDate(this.actStartDate)
                .cuit(this.cuit)
                .build();
    }
}
