package com.Bootcamp.Crisalis.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = {"localhost:8080", "localhost"})
public class OrderController {
}