package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.model.Tax;
import com.Bootcamp.Crisalis.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalculatedProductService {

        public BigDecimal calculatedTotalAmountProduct(ProductDTO productDTO) {
            BigDecimal total = new BigDecimal(0);

            total = total.add(productDTO.getBaseAmount());

            if (!ObjectUtils.isEmpty(productDTO.getTaxes())) {
                List<BigDecimal> taxes =
                        productDTO
                                .getTaxes()
                                .stream()
                                .map(Tax::getPercentage)
                                .collect(Collectors.toList());

                for ( BigDecimal t : taxes) {
                    total = total.add(total
                            .multiply(t)
                            .divide(new BigDecimal(100)));
                }
            }

//            if (productDTO.getGuarantee() > 0) {
//                BigDecimal guarantee = productDTO.getBaseAmount()
//                        .multiply(new BigDecimal(2))
//                        .divide(new BigDecimal(100));
//
//                int i = productDTO.getGuarantee();
//                while(i > 0) {
//                    total = total.add(guarantee);
//                    i--;
//                }
//            }
//
//            if (productDTO.getQuantity() > 1) {
//                BigDecimal aux = productDTO.getBaseAmount().multiply(new BigDecimal(productDTO.getQuantity()));
//                total = total.add(aux);
//            }
            return total;
        }
}
