package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.TypeService;
import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
import com.Bootcamp.Crisalis.model.dto.ServiceItemDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Service")
public class Service extends Need {

    @Column(name = "monthlyCost")
    private BigDecimal monthlyCost;

    @Column(name = "supportChange")
    private BigDecimal supportChange;

    @Column(name = "typeService")
    private TypeService typeService;

    public Service(ServiceDTO serviceDTO) {
        super(serviceDTO);
        this.monthlyCost = serviceDTO.getMonthlyCost();
        this.typeService = serviceDTO.getTypeService();
        this.supportChange = serviceDTO.getSupportChange();
    }

    public ServiceDTO toDTO() {
        return ServiceDTO
                .builder()
                .id(this.getId())
                .name(this.getName())
                .baseAmount(this.getBaseAmount())
                .taxes(this.getTaxes())
                .monthlyCost(this.monthlyCost)
                .typeService(this.typeService)
                .supportChange(this.supportChange)
                .build();
    }

    public ServiceItemDTO toServiceItemDTO() {
        return ServiceItemDTO
                .builder()
                .id(this.getId())
                .name(this.getName())
                .baseAmount(this.getBaseAmount())
                .typeService(this.typeService)
                .status(this.getStatus())
                .build();
    }

}
