package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.EmptyElementException;
import com.Bootcamp.Crisalis.exception.custom.NotCreatedException;
import com.Bootcamp.Crisalis.exception.custom.UnauthorizedException;
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
/*        if (ObjectUtils.isEmpty(orderDTO.getUser())) {
            throw new EmptyElementException("User is empty");
        }*/
/*        if (ObjectUtils.isEmpty(orderDTO.getServices()) &&
                ObjectUtils.isEmpty(orderDTO.getProducts())) {
            throw new EmptyElementException("Services and products are empty");
        }
        if (ObjectUtils.isEmpty(orderDTO.getClient())) {
            throw new EmptyElementException("Client is empty");
        }*/
        return Boolean.TRUE;
    }

    public Order deleteOrder(Integer id) {
        if (this.orderRepository.existsById(id)) {
            return this.orderRepository.deleteOrderById(id);
        }
        throw new UnauthorizedException("Order doesn't exist");
    }

    public List<OrderDTO> getListAllOrderInBD() {
        return this.orderRepository
                .findAll()
                .stream()
                .map(Order::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO findOrderById(Integer id) {
        if (this.orderRepository.existsById(id)) {
            return this.orderRepository.findOrderById(id);
        }
        throw new UnauthorizedException("Order doesn't exist");
    }

    public Order updateOrder(OrderDTO orderDTO, Integer id) {
        if (this.orderRepository.existsById(id)) {
            if (this.checkOrderDTO(OrderDTO
                    .builder()
                    .amount(orderDTO.getAmount())
                    .build())) {
                this.orderRepository.getReferenceById(id).setAmount(orderDTO.getAmount());
            }
        }
        if (this.orderRepository.existsById(id)) {
            if (this.checkOrderDTO(OrderDTO
                    .builder()
                    .dateCreated(orderDTO.getDateCreated())
                    .build())) {
                this.orderRepository.getReferenceById(id).setDateCreated(orderDTO.getDateCreated());
            }
        }
        if (this.orderRepository.existsById(id)) {
            if (this.checkOrderDTO(OrderDTO
                    .builder()
                    .description(orderDTO.getDescription())
                    .build())) {
                this.orderRepository.getReferenceById(id).setDescription(orderDTO.getDescription());
            }
        }
/*        if (this.orderRepository.existsById(id)) {
            if (this.checkOrderDTO(OrderDTO
                    .builder()
                    .user(orderDTO.getUser())
                    .build())) {
                this.orderRepository.getReferenceById(id).setUser(orderDTO.getUser());
            }
        }*/
        /*if (this.orderRepository.existsById(id)) {
            if (this.checkOrderDTO(OrderDTO
                    .builder()
                    .client(orderDTO.getClient())
                    .build())) {
                this.orderRepository.getReferenceById(id).setClient(orderDTO.getClient());
            }
        }
        if (this.orderRepository.existsById(id)) {
            if (this.checkOrderDTO(OrderDTO
                    .builder()
                    .products(orderDTO.getProducts())
                    .build())) {
                this.orderRepository.getReferenceById(id).setProducts(orderDTO.getProducts());
            }
        }
        if (this.orderRepository.existsById(id)) {
            if (this.checkOrderDTO(OrderDTO
                    .builder()
                    .services(orderDTO.getServices())
                    .build())) {
                this.orderRepository.getReferenceById(id).setServices(orderDTO.getServices());
            }
        }*/
        throw new UnauthorizedException("Order doesn't exist");
    }
}
