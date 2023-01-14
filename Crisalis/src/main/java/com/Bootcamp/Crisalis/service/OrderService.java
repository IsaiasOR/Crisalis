package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.EmptyElementException;
import com.Bootcamp.Crisalis.exception.custom.NotCreatedException;
import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import com.Bootcamp.Crisalis.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order creatingOrder(OrderDTO orderDTO) {
        if (checkOrderDTO(orderDTO)) {
            return this.orderRepository.save(new Order(orderDTO));
        }
        throw new NotCreatedException("Error creating order");
    }

    public Boolean checkOrderDTO(OrderDTO orderDTO) {
        if (ObjectUtils.isEmpty(orderDTO.getDateCreated())) {
            throw new EmptyElementException("Date created is empty");
        }
        if (ObjectUtils.isEmpty(orderDTO.getAmount())) {
            throw new EmptyElementException("Amount is empty");
        }
        if (StringUtils.isEmpty(orderDTO.getDescription())) {
            throw new EmptyElementException("Description is empty");
        }
        if (ObjectUtils.isEmpty(orderDTO.getUser())) {
            throw new EmptyElementException("User is empty");
        }
        if (ObjectUtils.isEmpty(orderDTO.getNeeds())) {
            throw new EmptyElementException("Needs is empty");
        }
        if (ObjectUtils.isEmpty(orderDTO.getClient())) {
            throw new EmptyElementException("Client is empty");
        }
        return Boolean.TRUE;
    }

    public void deleteOrder(Integer id) {
        this.orderRepository.deleteById(id);
    }

    public void findOrder(Integer id) {
         this.orderRepository.findById(id);
    }

    public List<OrderDTO> getListAllOrderInBD() {
        return this.orderRepository
                .findAll()
                .stream()
                .map(Order::toDTO)
                .collect(Collectors.toList());
    }
}
