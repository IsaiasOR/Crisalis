package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.enums.TypeService;
import com.Bootcamp.Crisalis.model.Tax;
import com.Bootcamp.Crisalis.model.dto.OrderDetailsDTO;
import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalculatedServiceService {

    public BigDecimal calculatedMonthlyCost(OrderDetailsDTO orderDetailsDTO) {
            BigDecimal cost = new BigDecimal(0);

            if (!ObjectUtils.isEmpty(orderDetailsDTO.getService())) {
                com.Bootcamp.Crisalis.model.Service service =  orderDetailsDTO.getService();

                cost = cost.add(service.getBaseAmount());

                if (service.getTypeService() == TypeService.SPECIAL) {
                    cost = cost.add(service.getSupportChange());
                }

                if (!ObjectUtils.isEmpty(orderDetailsDTO.getTaxes())){
                    List<BigDecimal> taxes = orderDetailsDTO
                            .getTaxes()
                            .stream()
                            .map(Tax::getPercentage)
                            .collect(Collectors.toList());

                    for (BigDecimal t : taxes) {
                        cost = cost.add(cost
                                .multiply(t)
                                .divide(new BigDecimal(100)));
                    }
                }

            }
            return cost;
        }

}
