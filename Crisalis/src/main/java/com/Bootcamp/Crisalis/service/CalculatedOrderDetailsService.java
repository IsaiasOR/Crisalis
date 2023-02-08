package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.Tax;
import com.Bootcamp.Crisalis.model.dto.OrderDetailsDTO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalculatedOrderDetailsService {

    private final CalculatedServiceService calculatedServiceService;

    public BigDecimal calculatedAmountOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        BigDecimal totalAmount = new BigDecimal(0);
        BigDecimal amountService = new BigDecimal(0);
        BigDecimal amountProduct = new BigDecimal(0);

        if (!ObjectUtils.isEmpty(orderDetailsDTO.getService())) {
            amountService = amountService.add(this.calculatedServiceService.calculatedMonthlyCost(orderDetailsDTO));
        }

        if (!ObjectUtils.isEmpty(orderDetailsDTO.getProduct())) {
            Product product =  orderDetailsDTO.getProduct();

            amountProduct = amountProduct.add(product.getBaseAmount());

            if (!ObjectUtils.isEmpty(orderDetailsDTO.getTaxes())){
                List<BigDecimal> taxes = orderDetailsDTO
                        .getTaxes()
                        .stream()
                        .map(Tax::getPercentage)
                        .collect(Collectors.toList());

                for (BigDecimal t : taxes) {
                    amountProduct = amountProduct.add(amountProduct
                            .multiply(t)
                            .divide(new BigDecimal(100)));
                }
            }

            if (!ObjectUtils.isEmpty(orderDetailsDTO.getQuantity()) &&
                orderDetailsDTO.getQuantity() > 0) {
                BigDecimal quantity = new BigDecimal(orderDetailsDTO.getQuantity());

                amountProduct = amountProduct.multiply(quantity);
            }

            if (!ObjectUtils.isEmpty(orderDetailsDTO.getGuarantee()) &&
                orderDetailsDTO.getGuarantee() > 0) {
                int guarantee = orderDetailsDTO.getGuarantee();

                while (guarantee > 0) {
                    amountProduct = amountProduct
                            .add(amountProduct
                            .multiply(new BigDecimal(2))
                            .divide(new BigDecimal(100)));

                    guarantee--;
                }
            }

        }

        totalAmount = totalAmount.add(amountProduct).add(amountService);
        return totalAmount;
    }
}
