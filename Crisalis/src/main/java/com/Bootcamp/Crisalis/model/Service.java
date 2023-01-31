package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.enums.TypeService;
import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
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

    //@Id
    /*@SequenceGenerator(
            name = "service_sequence",
            sequenceName = "service_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "service_sequence"
    )
    @Column(name = "id_service")
    private Integer id;*/

    @Column(name = "monthlyCost")
    private BigDecimal monthlyCost;

    @Column(name = "supportChange")
    private BigDecimal supportChange;

    @Column(name = "typeService")
    private TypeService typeService;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    @ToString.Exclude
    private Order order;*/

/*    @OneToOne(mappedBy = "service", cascade = CascadeType.ALL)
    private Need need;*/

   /* @JoinTable(
            name = "serviceTax",
            joinColumns = @JoinColumn(name = "fk_service"),
            inverseJoinColumns = @JoinColumn(name="fk_tax")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Tax> taxes = new HashSet<>();*/

    public Service(ServiceDTO serviceDTO) {
        super(serviceDTO);
        this.monthlyCost = serviceDTO.getMonthlyCost();
        this.typeService = serviceDTO.getTypeService();
        this.supportChange = serviceDTO.getSupportChange();
        /*this.order = serviceDTO.getOrder();
        this.taxes = serviceDTO.getTaxes();*/
        //this.need = serviceDTO.getNeed();
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
//                .order(this.order)
                //.need(this.need)
                .build();
    }

    //Método para calcular el costo mensual
}
