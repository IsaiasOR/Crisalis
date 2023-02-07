package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.OrderDetails;
import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import com.Bootcamp.Crisalis.model.dto.OrderDetailsDTO;
import com.Bootcamp.Crisalis.service.OrderDetailsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = {"localhost:8080", "localhost", "http://localhost:4200"})
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @PostMapping(value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDetails creatingOrderDetails(@RequestBody OrderDetailsDTO orderDetailsDTO) {
        return this.orderDetailsService.creatingOrder(orderDetailsDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteOrderDetails(@PathVariable("id") Integer id) {
        String msj = "Removal successful";
        this.orderDetailsService.deleteOrderDetailsById(id);
        return msj;
    }

    @GetMapping(value = "/findOrderDetails/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDetails findOrderDetails(@PathVariable("id") Integer id) {
        return this.orderDetailsService.findOrderDetailsById(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDetails updateOrder(@RequestBody OrderDetailsDTO orderDetailsDTO, @PathVariable("id") Integer id) {
        return this.orderDetailsService.updateOrderDetails(orderDetailsDTO, id);
    }
}
