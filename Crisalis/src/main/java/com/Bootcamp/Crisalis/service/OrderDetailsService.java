package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.OrderDetails;
import com.Bootcamp.Crisalis.model.dto.OrderDetailsDTO;
import com.Bootcamp.Crisalis.repository.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;
    private final CalculatedOrderDetailsService calculatedOrderDetailsService;

    public OrderDetails creatingOrder(OrderDetailsDTO orderDetailsDTO) {
        if (checkOrderDetailsDTO(orderDetailsDTO)) {
            orderDetailsDTO.setAmount(
                    this.calculatedOrderDetailsService
                            .calculatedAmountOrderDetails(orderDetailsDTO)
            );
            return this.orderDetailsRepository.save(new OrderDetails(orderDetailsDTO));
        }
        throw new NotCreatedException("Error creating order");
    }

    public Boolean checkOrderDetailsDTO(OrderDetailsDTO orderDetailsDTO) {
        if (ObjectUtils.isEmpty(orderDetailsDTO.getService()) &&
        ObjectUtils.isEmpty(orderDetailsDTO.getProduct())) {
            throw new EmptyElementException("Service and product are empty");
        }
        if (!ObjectUtils.isEmpty(orderDetailsDTO.getService()) &&
                !ObjectUtils.isEmpty(orderDetailsDTO.getProduct())) {
            throw new EmptyElementException("Single product or service");
        }
        if (ObjectUtils.isEmpty(orderDetailsDTO.getProduct()) &&
                !ObjectUtils.isEmpty(orderDetailsDTO.getQuantity())) {
            throw new EmptyElementException("Product is empty");
        }
        if (ObjectUtils.isEmpty(orderDetailsDTO.getProduct()) &&
                !ObjectUtils.isEmpty(orderDetailsDTO.getGuarantee())) {
            throw new EmptyElementException("Product is empty");
        }
        return Boolean.TRUE;
    }

    public void deleteOrderDetailsById(Integer id) {
        if (!this.orderDetailsRepository.existsById(id)) {
            throw new NotEliminatedException("Order details doesn't exist");
        }
        this.orderDetailsRepository.deleteById(id);
    }

    public OrderDetails findOrderDetailsById(Integer id) {
        return this.orderDetailsRepository.findById(id)
                .orElseThrow(
                        () -> new UnauthorizedException("Order details doesn't exist")
                );
    }

    public OrderDetails updateOrderDetails(OrderDetailsDTO orderDetailsDTO, Integer id) {
        OrderDetails newOrderDetails = orderDetailsRepository.getReferenceById(id);

        if (this.orderDetailsRepository.existsById(id)) {
            if (!ObjectUtils.isEmpty(orderDetailsDTO.getAmount())) {
                newOrderDetails.setAmount(orderDetailsDTO.getAmount());
            }
            if (!StringUtils.isEmpty(orderDetailsDTO.getDescription())) {
                newOrderDetails.setDescription(orderDetailsDTO.getDescription());
            }
            if (!ObjectUtils.isEmpty(orderDetailsDTO.getProduct())) {
                newOrderDetails.setProduct(orderDetailsDTO.getProduct());
            }
            if (!ObjectUtils.isEmpty(orderDetailsDTO.getQuantity())) {
                newOrderDetails.setQuantity(orderDetailsDTO.getQuantity());
            }
            if (!ObjectUtils.isEmpty(orderDetailsDTO.getGuarantee())) {
                newOrderDetails.setGuarantee(orderDetailsDTO.getGuarantee());
            }
            if (!ObjectUtils.isEmpty(orderDetailsDTO.getService())) {
                newOrderDetails.setService(orderDetailsDTO.getService());
            }
            return this.orderDetailsRepository.save(newOrderDetails);
        }
        throw new NotUpdateException("Order details doesn't exist");
    }

    public List<OrderDetails> getListAllOrderDetailsInBD() {
        return this.orderDetailsRepository.findAll();
    }

    public List<OrderDetails> orderDetailsNoOrder() {
        return this.orderDetailsRepository.orderDetailsNoOrder();
    }
}
