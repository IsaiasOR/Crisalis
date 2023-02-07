package com.Bootcamp.Crisalis.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculatedOrderService {

//    private CalculatedProductService calculatedProductService;
//
//    public BigDecimal calculatedTotalAmount(OrderDTO orderDTO) {
//        BigDecimal total = new BigDecimal(0);
//
//        if (!ObjectUtils.isEmpty(orderDTO.getProducts())) {
//
//            List<ProductDTO> listProductDTO = orderDTO
//                    .getProducts()
//                    .stream()
//                    .map(Product::toDTO)
//                    .collect(Collectors.toList());
//
//            for (ProductDTO p : listProductDTO ) {
//                total = total.add(calculatedProductService.calculatedTotalAmountProduct(p));
//            }
//
//        }
//        if (!ObjectUtils.isEmpty(orderDTO.getServices())) {
//            List<BigDecimal> amountServices =
//                    orderDTO
//                            .getServices()
//                            .stream()
//                            .map(com.Bootcamp.Crisalis.model.Service::getBaseAmount)
//                            .collect(Collectors.toList());
//
//            for ( BigDecimal s : amountServices) {
//                total = total.add(s);
//            }
//
//        }
//
//
//
//        return total;
//    }

}
