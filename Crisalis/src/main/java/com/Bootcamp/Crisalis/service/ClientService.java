package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.Client;
import com.Bootcamp.Crisalis.model.dto.ClientDTO;
import com.Bootcamp.Crisalis.model.dto.ClientItemDTO;
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
        if (ObjectUtils.isEmpty(clientDTO.getAddress())) {
            throw new EmptyElementException("Address is empty");
        }
        if (ObjectUtils.isEmpty(clientDTO.getPhoneNumber())) {
            throw new EmptyElementException("Phone number is empty");
        }
        return Boolean.TRUE;
    }

    public void deleteClientById(Integer id) {
        if (!this.clientRepository.existsById(id)) {
            throw new NotEliminatedException("Business doesn't exist");
        }
        this.clientRepository.deleteById(id);
    }

    public ClientDTO findClientByDni(Integer dni) {
        if(ObjectUtils.isEmpty(dni)) {
            throw new EmptyElementException("DNI is empty");
        }
        if(dni < 100000) {
            throw new UnauthorizedException("Invalid credentials");
        }
        return this.clientRepository.findByDni(dni)
                .orElseThrow(
                        () -> new UnauthorizedException("Client doesn't exist")
                ).toDTO();
    }

    public List<ClientItemDTO> getListAllClientsInBD() {
        return this.clientRepository
                .findAll()
                .stream()
                .map(Client::toCLientItemDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO findClientById(Integer id) {
        if (this.clientRepository.existsById(id)) {
            return this.clientRepository.findById(id).orElseThrow().toDTO();
        }
        throw new UnauthorizedException("Client doesn't exist");
    }

    public Client updateClient(ClientDTO clientDTO, Integer id) {
        Client newClient = clientRepository.getReferenceById(id);

        if (this.clientRepository.existsById(id)) {
            if (!ObjectUtils.isEmpty(clientDTO.getDni())) {
                newClient.setDni(clientDTO.getDni());
            }
            if (!StringUtils.isEmpty(clientDTO.getLastname())) {
                newClient.setLastname(clientDTO.getLastname());
            }
            if (!StringUtils.isEmpty(clientDTO.getFirstname())) {
                newClient.setFirstname(clientDTO.getFirstname());
            }
            if (!StringUtils.isEmpty(clientDTO.getEmail())) {
                newClient.setEmail(clientDTO.getEmail());
            }
            if (!ObjectUtils.isEmpty(clientDTO.getActiveService())) {
                newClient.setActiveService(clientDTO.getActiveService());
            }
            if (!StringUtils.isEmpty(clientDTO.getPhoneNumber())) {
                newClient.setPhoneNumber(clientDTO.getPhoneNumber());
            }
            if (!StringUtils.isEmpty(clientDTO.getAddress())) {
                newClient.setAddress(clientDTO.getAddress());
            }
            newClient.setBusiness(clientDTO.getBusiness());
            return this.clientRepository.save(newClient);
        }
        throw new NotUpdateException("Client doesn't exist");
    }

    public List<Client> getAllClientsCompleteInBD() {
        return this.clientRepository.findAll();
    }
}

