package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.EmptyElementException;
import com.Bootcamp.Crisalis.exception.custom.NotCreatedException;
import com.Bootcamp.Crisalis.exception.custom.NotEliminatedException;
import com.Bootcamp.Crisalis.exception.custom.UnauthorizedException;
import com.Bootcamp.Crisalis.model.Need;
import com.Bootcamp.Crisalis.model.Service;
import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
import com.Bootcamp.Crisalis.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public Service saveService(ServiceDTO serviceDTO) {
        if (checkServiceDTO(serviceDTO)) {
            return this.serviceRepository.save(new Service(serviceDTO));
        }
        throw new NotCreatedException("Error in save new service");
    }

    private Boolean checkServiceDTO(ServiceDTO serviceDTO) {
        if (StringUtils.isEmpty(serviceDTO.getName())) {
            throw new EmptyElementException("Name is empty");
        }
        if (ObjectUtils.isEmpty(serviceDTO.getBaseAmount())) {
            throw new EmptyElementException("Base amount is empty");
        }
        if (ObjectUtils.isEmpty(serviceDTO.getMonthlyCost())) {
            throw new EmptyElementException("Monthly cost is empty");
        }
        if (ObjectUtils.isEmpty(serviceDTO.getNeed())) {
            throw new EmptyElementException("Need is empty");
        }
        if (ObjectUtils.isEmpty(serviceDTO.getSupportChange())) {
            throw new EmptyElementException("Support change is empty");
        }
        return Boolean.TRUE;
    }

    public Service deleteServiceByNeed(Need need) {
        if (checkServiceDTO(ServiceDTO
                .builder()
                .need(need)
                .build())) {
            return this.serviceRepository.deleteByNeed(need);
        }
        throw new NotEliminatedException("Error in deleting product");
    }

    public void deleteServiceById(Integer id) {
         this.serviceRepository.deleteById(id);
    }

    public ServiceDTO findServiceByNeed(Need need) {
        if (checkServiceDTO(ServiceDTO
                .builder()
                .need(need)
                .build())) {
            return this.serviceRepository.findByNeed(need)
                    .orElseThrow(
                            () -> new UnauthorizedException("Service doesn't exist")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    public List<ServiceDTO> getListAllServicesInBD() {
        return this.serviceRepository
                .findAll()
                .stream()
                .map(Service::toDTO)
                .collect(Collectors.toList());
    }
}
