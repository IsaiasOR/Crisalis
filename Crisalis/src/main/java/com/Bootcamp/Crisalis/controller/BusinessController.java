package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Business;
import com.Bootcamp.Crisalis.model.dto.BusinessDTO;
import com.Bootcamp.Crisalis.service.BusinessService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping(value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Business saveBusiness(@RequestBody BusinessDTO businessDTO) {
        return this.businessService.saveBusiness(businessDTO);
    }

    @DeleteMapping(value = "/deleteByCuit/{cuit}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Business deleteBusinessByCuit(@PathVariable("cuit") Integer cuit) {
        return this.businessService.deleteBusinessByCuit(cuit);
    }

    @DeleteMapping(value = "/deleteById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Business deleteBusinessById(@PathVariable("id") Integer id) {
        return this.businessService.deleteBusinessById(id);
    }

    @GetMapping(value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusinessDTO> getListAllBusinessInBD() {
        return businessService.getListAllBusinessInBD();
    }

    @GetMapping(value = "/findBusiness/{cuit}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BusinessDTO findBusinessByCuit(@PathVariable("cuit") Integer cuit) {
        return this.businessService.findByCuit(cuit);
    }

    @GetMapping(value = "/findBusinessById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BusinessDTO findBusinessById(@PathVariable("id") Integer id) {
        return this.businessService.findBusinessById(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Business updateBusiness(@RequestBody BusinessDTO businessDTO, @PathVariable("id") Integer id) {
        return this.businessService.updateBusiness(businessDTO, id);
    }
}
