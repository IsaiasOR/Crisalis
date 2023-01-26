package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import com.Bootcamp.Crisalis.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = {"localhost:8080", "localhost", "http://localhost:4200"})
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Order creatingOrder(@RequestBody OrderDTO orderDTO) {
        return this.orderService.creatingOrder(orderDTO);
    }

    @GetMapping(value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders() {
        return this.orderService.getListAllOrderInBD();
    }

/*    @DeleteMapping(value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Order deleteOrder(@PathVariable("id") Integer id) {
        return this.orderService.deleteOrder(id);
    }*/

    @GetMapping(value = "/findOrder/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO findOrder(@PathVariable("id") Integer id) {
        return this.orderService.findOrderById(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable("id") Integer id) {
        return this.orderService.updateOrder(orderDTO, id);
    }
}
