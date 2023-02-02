package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Client;
import com.Bootcamp.Crisalis.model.dto.ClientDTO;
import com.Bootcamp.Crisalis.model.dto.ClientItemDTO;
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

    @PostMapping(value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Client saveClient(@RequestBody ClientDTO clientDTO) {
        return this.clientService.saveClient(clientDTO);
    }

/*   @DeleteMapping(value = "/deleteByDni/{dni}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Client deleteClientByDni(@PathVariable("dni") Integer dni) {
        return this.clientService.deleteClientByDni(dni);
    }*/

    @DeleteMapping(value = "/deleteById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteClientById(@PathVariable("id") Integer id) {
        String msj = "Removal successful";
        this.clientService.deleteClientById(id);
        return msj;
    }

    @GetMapping(value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientItemDTO> getListAllClientsInBD() {
        return clientService.getListAllClientsInBD();
    }

    @GetMapping(value = "/findClientByDni/{dni}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO findClientByDni(@PathVariable("dni") Integer dni) {
        return this.clientService.findClientByDni(dni);
    }

    @GetMapping(value = "/findClientById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Client findClientById(@PathVariable("id") Integer id) {
        return this.clientService.findClientById(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Client updateClient(@RequestBody ClientDTO clientDTO, @PathVariable("id") Integer id) {
        return this.clientService.updateClient(clientDTO, id);
    }
}
