package com.Bootcamp.Crisalis.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculatedServiceService {

//        public BigDecimal calculatedMonthlyCost(ServiceDTO serviceDTO) {
//            BigDecimal cost = new BigDecimal(0);
//            cost = cost.add(serviceDTO.getBaseAmount());
//
//            if (!ObjectUtils.isEmpty(serviceDTO.getTaxes())) {
//                List<BigDecimal> taxes =
//                        serviceDTO
//                                .getTaxes()
//                                .stream()
//                                .map(Tax::getPercentage)
//                                .collect(Collectors.toList());
//
//                for (BigDecimal t : taxes) {
//                    cost = cost.add(cost
//                            .multiply(t)
//                            .divide(new BigDecimal(100)));
//                }
//            }
//
//            if (serviceDTO.getTypeService() == TypeService.SPECIAL) {
//                cost.add(serviceDTO.getSupportChange());
//            }
//
//            return cost;
//        }

}
