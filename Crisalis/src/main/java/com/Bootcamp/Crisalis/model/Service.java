package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name= "service")
@PrimaryKeyJoinColumn(name="id_need")
public class Service extends Need {

    @Id
    @SequenceGenerator(
            name = "service_sequence",
            sequenceName = "service_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "service_sequence"
    )
    @Column(name = "id_service")
    private Integer id;

    @Column(name = "monthlyCost")
    private BigDecimal monthlyCost;

    @Column(name = "supportChange")
    private BigDecimal supportChange;

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
