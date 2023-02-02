package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import com.Bootcamp.Crisalis.model.dto.OrderDetailsDTO;
import com.Bootcamp.Crisalis.model.dto.OrderItemDTO;
import com.Bootcamp.Crisalis.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<OrderItemDTO> getAllOrders() {
        return this.orderService.getListAllOrderInBD();
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteOrder(@PathVariable("id") Integer id) {
        String msj = "Removal successful";
        this.orderService.deleteOrderById(id);
        return msj;
    }

    @GetMapping(value = "/findOrder/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Order findOrder(@PathVariable("id") Integer id) {
        return this.orderService.findOrderById(id);
    }

    @GetMapping(value = "/findOrderDetails/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<OrderDetailsDTO> findOrderDetails(@PathVariable("id") Integer id) {
        return this.orderService.findOrderDetails(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable("id") Integer id) {
        return this.orderService.updateOrder(orderDTO, id);
    }

//    @PutMapping(value = "/updateStatus/{id}",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public Order updateStatus(@RequestBody Status status, @PathVariable("id") Integer id) {
//        return this.orderService.updateStatus(id, status);
//    }
}
