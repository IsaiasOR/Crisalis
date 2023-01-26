package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Service;
import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
import com.Bootcamp.Crisalis.service.ServiceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
@CrossOrigin(origins = {"localhost:8080", "localhost", "http://localhost:4200"})
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @PostMapping(value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Service saveService(@RequestBody ServiceDTO serviceDTO) {
        return this.service.saveService(serviceDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteServiceById(@PathVariable("id") Integer id) {
        String msj = "Removal successful";
        this.service.deleteServiceById(id);
        return msj;
    }

    @GetMapping(value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServiceDTO> getListAllServicesInBD() {
        return this.service.getListAllServicesInBD();
    }

    @GetMapping(value = "/findService/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Service findServiceById(@PathVariable("id") Integer id) {
        return this.service.findServiceById(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Service updateBusiness(@RequestBody ServiceDTO serviceDTO, @PathVariable("id") Integer id) {
        return this.service.updateService(serviceDTO, id);
    }
}
