package com.Bootcamp.Crisalis.model;

import com.Bootcamp.Crisalis.model.dto.ProductDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name= "product")
//@PrimaryKeyJoinColumn(name="id_need")
@DiscriminatorValue("Product")
public class Product extends Need {

    //@Id
    /*@SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "id_product")
    private Integer id;
*/
    @Column(name = "guarantee")
    private Integer guarantee;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    @ToString.Exclude
    private Order order;*/

/*    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Need need;*/

  /*  @JoinTable(
            name = "productTax",
            joinColumns = @JoinColumn(name = "fk_product"),
            inverseJoinColumns = @JoinColumn(name="fk_tax")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Tax> taxes = new HashSet<>();*/


    public Product(ProductDTO productDTO) {
        super(productDTO);
        /*this.setBaseAmount(productDTO.getBaseAmount());
        this.setName(productDTO.getName());*/
        this.guarantee = productDTO.getGuarantee();
        /*this.order = productDTO.getOrder();
        this.taxes = productDTO.getTaxes();*/
        //this.need = productDTO.getNeed();
    }

    public ProductDTO toDTO() {
        return ProductDTO
                .builder()
                .guarantee(this.guarantee)
                /*.order(this.order)
                .taxes((HashSet<Tax>) this.taxes)*/
                //.need(this.need)
                .build();
    }

}
