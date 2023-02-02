package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import com.Bootcamp.Crisalis.model.dto.ProductItemDTO;
import com.Bootcamp.Crisalis.model.dto.ServiceItemDTO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalculatedService {

    public BigDecimal calculatedTotalAmount(OrderDTO orderDTO) {
        BigDecimal total = new BigDecimal(0);

        if (!ObjectUtils.isEmpty(orderDTO.getProducts())) {
            List<BigDecimal> amountProducts =
                    orderDTO
                            .getProducts()
                            .stream()
                            .map(Product::getBaseAmount)
                            .collect(Collectors.toList());

            for ( BigDecimal p : amountProducts) {
                total = total.add(p);
            }

        }
        if (!ObjectUtils.isEmpty(orderDTO.getServices())) {
            List<BigDecimal> amountServices =
                    orderDTO
                            .getServices()
                            .stream()
                            .map(com.Bootcamp.Crisalis.model.Service::getBaseAmount)
                            .collect(Collectors.toList());

            for ( BigDecimal s : amountServices) {
                total = total.add(s);
            }

        }
        return total;
    }
}
