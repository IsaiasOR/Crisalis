package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import com.Bootcamp.Crisalis.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = {"localhost:8080", "localhost"})
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order creatingOrder(@RequestBody OrderDTO orderDTO) {
        return this.orderService.creatingOrder(orderDTO);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders() {
        return this.orderService.getListAllOrderInBD();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOrder(@RequestParam Integer id) {
        this.orderService.deleteOrder(id);
    }

    @GetMapping(value = "/findOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public void findOrder(@RequestParam Integer id) {
        this.orderService.findOrder(id);
    }
}
