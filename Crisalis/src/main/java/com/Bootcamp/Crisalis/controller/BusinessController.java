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

    @GetMapping(value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusinessDTO> getListAllBusinessInBD() {
        return this.businessService.getListAllBusinessInBD();
    }

    @GetMapping(value = "/findBusinessByCuit/{cuit}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Business findBusinessByCuit(@PathVariable("cuit") String cuit) {
        return this.businessService.findByCuit(cuit);
    }

    @GetMapping(value = "/findBusinessById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Business findBusinessById(@PathVariable("id") Integer id) {
        return this.businessService.findBusinessById(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Business updateBusiness(@RequestBody BusinessDTO businessDTO,
                                   @PathVariable("id") Integer id) {
        return this.businessService.updateBusiness(businessDTO, id);
    }

/*    @DeleteMapping(value = "/deleteByCuit/{cuit}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Business> deleteBusinessByCuit(@PathVariable("cuit") String cuit) {
        return this.businessService.deleteBusinessByCuit(cuit);
    }*/

    @DeleteMapping(value = "/deleteById/{id}")
    public String deleteBusinessById(@PathVariable("id") Integer id) {
        String msj = "Removal successful";
        this.businessService.deleteBusinessById(id);
        return msj;
    }
}
