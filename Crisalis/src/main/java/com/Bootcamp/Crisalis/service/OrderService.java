package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.enums.Status;
import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.dto.*;
import com.Bootcamp.Crisalis.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CalculatedService calculatedService;

    public Order creatingOrder(OrderDTO orderDTO) {
        if (checkOrderDTO(orderDTO)) {
            String date = DateTimeFormatter.ofPattern("MMM dd yyyy")
                    .format(LocalDateTime.now());
            orderDTO.setDateCreated(date);
            orderDTO.setStatus(Status.ACTIVE);
            orderDTO.setAmount(calculatedService.calculatedTotalAmount(orderDTO));
            return this.orderRepository.save(new Order(orderDTO));
        }
        throw new NotCreatedException("Error creating order");
    }

    public Boolean checkOrderDTO(OrderDTO orderDTO) {
        if (ObjectUtils.isEmpty(orderDTO.getUser())) {
            throw new EmptyElementException("User is empty");
        }
       if (ObjectUtils.isEmpty(orderDTO.getServices()) &&
                ObjectUtils.isEmpty(orderDTO.getProducts())) {
            throw new EmptyElementException("Services and products are empty");
        }
        if (ObjectUtils.isEmpty(orderDTO.getClient())) {
            throw new EmptyElementException("Client is empty");
        }
        return Boolean.TRUE;
    }

    public void deleteOrderById(Integer id) {
        if (!this.orderRepository.existsById(id)) {
            throw new NotEliminatedException("Order doesn't exist");
        }
        this.orderRepository.deleteById(id);
    }

    public List<OrderItemDTO> getListAllOrderInBD() {
        return this.orderRepository
                .findAll()
                .stream()
                .map(Order::toOrderItemDTO)
                .collect(Collectors.toList());
    }

    public Order findOrderById(Integer id) {
        return this.orderRepository.findById(id)
                .orElseThrow(
                        () -> new UnauthorizedException("Order doesn't exist")
                );
    }

    public Order updateOrder(OrderDTO orderDTO, Integer id) {
        Order newOrder = orderRepository.getReferenceById(id);

        if (this.orderRepository.existsById(id)) {
            if (!StringUtils.isEmpty(orderDTO.getDateCreated())) {
                newOrder.setDateCreated(orderDTO.getDateCreated());
            }
            if (!StringUtils.isEmpty(orderDTO.getDescription())) {
                newOrder.setDescription(orderDTO.getDescription());
            }
            if (!ObjectUtils.isEmpty(orderDTO.getClient())) {
                newOrder.setClient(orderDTO.getClient());
            }
            if (!ObjectUtils.isEmpty(orderDTO.getProducts())) {
                newOrder.setProducts(orderDTO.getProducts());
            }
            if (!ObjectUtils.isEmpty(orderDTO.getServices())) {
                newOrder.setServices(orderDTO.getServices());
            }
            if (!ObjectUtils.isEmpty(orderDTO.getUser())) {
                newOrder.setUser(orderDTO.getUser());
            }
            if (!ObjectUtils.isEmpty(orderDTO.getStatus())) {
                newOrder.setStatus(orderDTO.getStatus());
            }
            return this.orderRepository.save(newOrder);
        }
        throw new NotUpdateException("Order doesn't exist");
    }

    public Optional<OrderDetailsDTO> findOrderDetails(Integer id) {
        if (!this.orderRepository.existsById(id)) {
            throw new NotEliminatedException("Order doesn't exist");
        }
        return this.orderRepository
                .findById(id)
                .map(Order::toOrderDetailsDTO);
    }

//    public Order updateStatus(Integer id, Status status) {
//        Order newOrder = orderRepository.getReferenceById(id);
//
//        if (this.orderRepository.existsById(id)) {
//            if (status == Status.ACTIVE) {
//                newOrder.setStatus(Status.ACTIVE);
//            } else {
//                newOrder.setStatus(Status.INACTIVE);
//            }
//            return this.orderRepository.save(newOrder);
//        }
//        throw new NotUpdateException("Order doesn't exist");
//    }
}
