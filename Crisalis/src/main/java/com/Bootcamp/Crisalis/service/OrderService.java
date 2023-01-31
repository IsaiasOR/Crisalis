package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.Product;
import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import com.Bootcamp.Crisalis.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order creatingOrder(OrderDTO orderDTO) {
        if (checkOrderDTO(orderDTO)) {
            orderDTO.setAmount(calculatedTotalAmount(orderDTO));
            return this.orderRepository.save(new Order(orderDTO));
        }
        throw new NotCreatedException("Error creating order");
    }

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

    public Boolean checkOrderDTO(OrderDTO orderDTO) {
        if (ObjectUtils.isEmpty(orderDTO.getDateCreated())) {
            throw new EmptyElementException("Date created is empty");
        }
        if (StringUtils.isEmpty(orderDTO.getDescription())) {
            throw new EmptyElementException("Description is empty");
        }
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

    public List<OrderDTO> getListAllOrderInBD() {
        return this.orderRepository
                .findAll()
                .stream()
                .map(Order::toDTO)
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
            if (!ObjectUtils.isEmpty(orderDTO.getDateCreated())) {
                newOrder.setDateCreated(orderDTO.getDateCreated());
            }
//            if (!ObjectUtils.isEmpty(orderDTO.getAmount())) {
//                newOrder.setAmount(orderDTO.getAmount());
//            }
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
            return this.orderRepository.save(newOrder);
        }
        throw new NotUpdateException("Order doesn't exist");
    }

}
