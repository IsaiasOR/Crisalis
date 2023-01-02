package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.EmptyElementException;
import com.Bootcamp.Crisalis.exception.custom.NotCreatedException;
import com.Bootcamp.Crisalis.exception.custom.NotEliminatedException;
import com.Bootcamp.Crisalis.exception.custom.UnauthorizedException;
import com.Bootcamp.Crisalis.model.Client;
import com.Bootcamp.Crisalis.model.dto.ClientDTO;
import com.Bootcamp.Crisalis.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client saveClient(ClientDTO clientDTO) {
        if (checkClientDTO(clientDTO)) {
            return this.clientRepository.save(new Client(clientDTO));
        }
        throw new NotCreatedException("Error in save new client");
    }

    public Boolean checkClientDTO(ClientDTO clientDTO) {
        if (ObjectUtils.isEmpty(clientDTO.getDni())) {
            throw new EmptyElementException("DNI is empty");
        }
        if (StringUtils.isEmpty(clientDTO.getLastname())) {
            throw new EmptyElementException("Last name is empty");
        }
        if (StringUtils.isEmpty(clientDTO.getFirstname())) {
            throw new EmptyElementException("First name is empty");
        }
        if (StringUtils.isEmpty(clientDTO.getEmail())) {
            throw new EmptyElementException("Email is empty");
        }
        if (ObjectUtils.isEmpty(clientDTO.getActiveService())) {
            throw new EmptyElementException("Active service is empty");
        }
        return Boolean.TRUE;
    }

    public Client deleteClientByDni(Integer dni) {
        if (checkClientDTO(ClientDTO
                .builder()
                .dni(dni)
                .build())) {
            return this.clientRepository.deleteByDni(dni);
        }
        throw new NotEliminatedException("Error in deleting client");
    }


    public void deleteClientById(Integer id) {
        this.clientRepository.deleteById(id);
    }

    public ClientDTO findClientByDni(Integer dni) {
        if (
                this.checkClientDTO(ClientDTO
                                .builder()
                                .dni(dni)
                                .build())
        ) {
            return this.clientRepository.findByDni(dni)
                    .orElseThrow(
                            () -> new UnauthorizedException("Client doesn't exist")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    public List<ClientDTO> getListAllClientsInBD() {
        return this.clientRepository
                .findAll()
                .stream()
                .map(Client::toDTO)
                .collect(Collectors.toList());
    }
}
