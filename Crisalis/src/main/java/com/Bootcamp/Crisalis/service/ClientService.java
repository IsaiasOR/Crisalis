package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.Client;
import com.Bootcamp.Crisalis.model.dto.BusinessDTO;
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

    public Client deleteClientById(Integer id) {
        if (this.clientRepository.existsById(id)) {
            return this.clientRepository.deleteClientById(id);
        }
        throw new NotEliminatedException("Business doesn't exist");
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

    public ClientDTO findClientById(Integer id) {
        if (this.clientRepository.existsById(id)) {
            return this.clientRepository.findClientById(id);
        }
        throw new UnauthorizedException("Client doesn't exist");
    }

    public Client updateClient(ClientDTO clientDTO, Integer id) {
        if (this.clientRepository.existsById(id)) {
            if (checkClientDTO(ClientDTO
                    .builder()
                    .dni(clientDTO.getDni())
                    .build())) {
                this.clientRepository.getReferenceById(id).setDni(clientDTO.getDni());
            }
            if (checkClientDTO(ClientDTO
                    .builder()
                    .firstname(clientDTO.getFirstname())
                    .build())) {
                this.clientRepository.getReferenceById(id).setFirstname(clientDTO.getFirstname());
            }
            if (checkClientDTO(ClientDTO
                    .builder()
                    .lastname(clientDTO.getLastname())
                    .build())) {
                this.clientRepository.getReferenceById(id).setLastname(clientDTO.getLastname());
            }
            if (checkClientDTO(ClientDTO
                    .builder()
                    .email(clientDTO.getEmail())
                    .build())) {
                this.clientRepository.getReferenceById(id).setEmail(clientDTO.getEmail());
            }
            if (checkClientDTO(ClientDTO
                    .builder()
                    .activeService(clientDTO.getActiveService())
                    .build())) {
                this.clientRepository.getReferenceById(id).setActiveService(clientDTO.getActiveService());
            }
            if (checkClientDTO(ClientDTO
                    .builder()
                    .businessSet(clientDTO.getBusinessSet())
                    .build())) {
                this.clientRepository.getReferenceById(id).setBusinessSet(clientDTO.getBusinessSet());
            }
            if (checkClientDTO(ClientDTO
                    .builder()
                    .orders(clientDTO.getOrders())
                    .build())) {
                this.clientRepository.getReferenceById(id).setOrders(clientDTO.getOrders());
            }
            return this.clientRepository.getReferenceById(id);
        }
        throw new NotUpdateException("Client doesn't exist");
    }
}

