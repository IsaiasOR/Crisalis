package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Client;
import com.Bootcamp.Crisalis.model.dto.ClientDTO;
import com.Bootcamp.Crisalis.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = {"localhost:8080", "localhost", "http://localhost:4200"})
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client saveClient(@RequestBody ClientDTO clientDTO) {
        return this.clientService.saveClient(clientDTO);
    }


    @DeleteMapping(value = "/deleteByDni", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client deleteClientByDni(@RequestParam Integer dni) {
        return this.clientService.deleteClientByDni(dni);
    }

    @DeleteMapping(value = "/deleteById", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteClientById(@RequestParam Integer id) {
        this.clientService.deleteClientById(id);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDTO> getListAllClientsInBD() {
        return clientService.getListAllClientsInBD();
    }

    @GetMapping(value = "/findClient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO findClientByDni(@RequestBody Integer dni) {
        return this.clientService.findClientByDni(dni);
    }
}
