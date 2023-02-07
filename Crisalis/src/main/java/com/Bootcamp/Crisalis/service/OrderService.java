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

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order creatingOrder(OrderDTO orderDTO) {
        if (checkOrderDTO(orderDTO)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            orderDTO.setDateCreated(dtf.format(LocalDateTime.now()));
            orderDTO.setStatus(Status.ACTIVE);
            return this.orderRepository.save(new Order(orderDTO));
        }
        throw new NotCreatedException("Error creating order");
    }

    public Boolean checkOrderDTO(OrderDTO orderDTO) {
        if (ObjectUtils.isEmpty(orderDTO.getUser())) {
            throw new EmptyElementException("User is empty");
        }
        if (ObjectUtils.isEmpty(orderDTO.getClient())) {
           throw new EmptyElementException("Client is empty");
        }
        if (ObjectUtils.isEmpty(orderDTO.getOrderDetails())) {
            throw new EmptyElementException("Order details are empty");
        }
        return Boolean.TRUE;
    }

    public void deleteOrderById(Integer id) {
        if (!this.orderRepository.existsById(id)) {
            throw new NotEliminatedException("Order doesn't exist");
        }
        this.orderRepository.deleteById(id);
    }

    public List<Order> getListAllOrderInBD() {
        return this.orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Integer id) {
        if (!this.orderRepository.existsById(id)) {
            throw new UnauthorizedException("Order doesn't exist");
        }
        return this.orderRepository.findById(id);
    }

    public Order updateOrder(OrderDTO orderDTO, Integer id) {
        Order newOrder = orderRepository.getReferenceById(id);

        if (this.orderRepository.existsById(id)) {
            if (!StringUtils.isEmpty(orderDTO.getDescription())) {
                newOrder.setDescription(orderDTO.getDescription());
            }
            if (!ObjectUtils.isEmpty(orderDTO.getClient())) {
                newOrder.setClient(orderDTO.getClient());
            }
            if (!ObjectUtils.isEmpty(orderDTO.getUser())) {
                newOrder.setUser(orderDTO.getUser());
            }
            if (!ObjectUtils.isEmpty(orderDTO.getStatus())) {
                newOrder.setStatus(orderDTO.getStatus());
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            newOrder.setDateCreated(dtf.format(LocalDateTime.now()));
            return this.orderRepository.save(newOrder);
        }
        throw new NotUpdateException("Order doesn't exist");
    }

//    public Optional<OrderDetailsDTO> findOrderDetails(Integer id) {
//        if (!this.orderRepository.existsById(id)) {
//            throw new NotEliminatedException("Order doesn't exist");
//        }
//        return this.orderRepository
//                .findById(id)
//                .map(Order::toOrderDetailsDTO);
//    }
}
