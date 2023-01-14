package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Need;
import com.Bootcamp.Crisalis.model.Service;
import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
import com.Bootcamp.Crisalis.service.ServiceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = {"localhost:8080", "localhost"})
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Service saveService(@RequestBody ServiceDTO serviceDTO) {
        return this.service.saveService(serviceDTO);
    }

    @DeleteMapping(value = "/delete/need", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Service deleteServiceByNeed(@RequestParam Need need) {
        return this.service.deleteServiceByNeed(need);
    }

    @DeleteMapping(value = "/delete/id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteServiceById(@RequestParam Integer id) {
        this.service.deleteServiceById(id);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServiceDTO> getListAllServicesInBD() {
        return this.service.getListAllServicesInBD();
    }

    @GetMapping(value = "/findNeed", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceDTO findServiceByNeed(@RequestBody Need need) {
        return this.service.findServiceByNeed(need);
    }
}
