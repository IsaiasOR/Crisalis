package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Business;
import com.Bootcamp.Crisalis.model.dto.BusinessDTO;
import com.Bootcamp.Crisalis.service.BusinessService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business")
@CrossOrigin(origins = {"localhost:8080", "localhost", "http://localhost:4200"})
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Business saveBusiness(@RequestBody BusinessDTO businessDTO) {
        return this.businessService.saveBusiness(businessDTO);
    }

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Business deleteBusiness(@RequestParam Integer cuit) {
        return this.businessService.deleteBusiness(cuit);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusinessDTO> getListAllBusinessInBD() {
        return businessService.getListAllBusinessInBD();
    }

    @GetMapping(value = "/findBusiness", produces = MediaType.APPLICATION_JSON_VALUE)
    public BusinessDTO findBusinessByCuit(@RequestBody Integer cuit) {
        return this.businessService.findByCuit(cuit);
    }
}
