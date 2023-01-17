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

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Service saveService(@RequestBody ServiceDTO serviceDTO) {
        return this.service.saveService(serviceDTO);
    }

    @DeleteMapping(value = "/deleteById", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteServiceById(@RequestParam Integer id) {
        this.service.deleteServiceById(id);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServiceDTO> getListAllServicesInBD() {
        return this.service.getListAllServicesInBD();
    }

    @GetMapping(value = "/findService", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceDTO findServiceById(@RequestBody Integer id) {
        return this.service.findServiceById(id);
    }
}
