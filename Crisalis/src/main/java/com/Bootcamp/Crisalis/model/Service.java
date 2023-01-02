package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.NeedDTO;
import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Service")
@PrimaryKeyJoinColumn(name="Id_Need")
public class Service extends Need {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Service")
    private Integer id;

    @Column(name = "MonthlyCost")
    private Double monthlyCost;

    @Column(name = "SupportChange")
    private Double supportChange;

    @OneToOne(mappedBy = "service", cascade = CascadeType.ALL)
    private Need need;

    public Service(ServiceDTO serviceDTO) {
        this.monthlyCost = serviceDTO.getMonthlyCost();
        this.supportChange = serviceDTO.getSupportChange();
        this.need = serviceDTO.getNeed();
    }

    public ServiceDTO toDTO() {
        return ServiceDTO
                .builder()
                .monthlyCost(this.monthlyCost)
                .supportChange(this.supportChange)
                .need(this.need)
                .build();
    }

    //Método para calcular el costo mensual
}
