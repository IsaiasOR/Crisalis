package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.model.OrderDetails;
import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import com.Bootcamp.Crisalis.model.dto.OrderDetailsDTO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalculatedOrderService {

    private final CalculatedOrderDetailsService calculatedOrderDetailsService;

    public BigDecimal calculatedTotalAmount(OrderDTO orderDTO) {
        BigDecimal total = new BigDecimal(0);

        if (!ObjectUtils.isEmpty(orderDTO.getOrderDetails())) {

            List<OrderDetailsDTO> orderDetailsList = orderDTO
                    .getOrderDetails()
                    .stream()
                    .map(OrderDetails::toOrderDetailsDTO)
                    .collect(Collectors.toList());


            for (OrderDetailsDTO order :  orderDetailsList) {
                total = total.add(
                        this.calculatedOrderDetailsService.calculatedAmountOrderDetails(order)
                );
            }

        }

        return total;
    }

}
