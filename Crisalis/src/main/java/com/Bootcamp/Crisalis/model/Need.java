package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.NeedDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "need")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="need_type",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("not null")
public class Need {

    @Id
    @SequenceGenerator(
            name = "need_sequence",
            sequenceName = "need_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "need_sequence"
    )
    @Column(name = "id_need")
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "baseAmount", nullable = false)
    private BigDecimal baseAmount;

    public Need(NeedDTO needDTO) {
        this.name = needDTO.getName();
        this.baseAmount = needDTO.getBaseAmount();
    }

    public NeedDTO toDTO() {
        return NeedDTO
                .builder()
                .id(this.id)
                .name(this.name)
                .baseAmount(this.baseAmount)
                .build();
    }
}
