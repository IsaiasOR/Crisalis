package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.BusinessDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business")
public class Business {

    @Id
    @SequenceGenerator(
            name = "business_sequence",
            sequenceName = "business_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "business_sequence"
    )
    @Column(name = "id_business")
    private Integer id;

    @Column(name = "businessName", nullable = false, length = 50)
    private String businessName;

    @Column(name = "actStartDate", nullable = false)
    private LocalDate actStartDate;

    @Column(name = "cuit", nullable = false)
    private String cuit;

//    @OneToMany(
//            cascade = CascadeType.MERGE,
//            fetch = FetchType.LAZY
//    )
//    @ToString.Exclude
//    private Set<Client> clients = new HashSet<>();

    public Business(BusinessDTO businessDTO) {
        this.businessName = businessDTO.getBusinessName();
        this.actStartDate = businessDTO.getActStartDate();
        this.cuit = businessDTO.getCuit();
//        this.clients = businessDTO.getClients();
    }

    public BusinessDTO toDTO() {
        return BusinessDTO
                .builder()
                .id(this.id)
                .businessName(this.businessName)
                .actStartDate(this.actStartDate)
                .cuit(this.cuit)
//                .clients(this.clients)
                .build();
    }
}
