package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.*;
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
        return Boolean.TRUE;
    }

    public ServiceDTO deleteServiceById(Integer id) {
        if (this.serviceRepository.existsById(id)) {
            return this.serviceRepository.deleteServiceById(id);
        }
        throw new NotEliminatedException("Service doesn't exist");
    }

    public ServiceDTO findServiceById(Integer id) {
            return this.serviceRepository.findById(id)
                    .orElseThrow(
                            () -> new UnauthorizedException("Service doesn't exist")
                    ).toDTO();
    }

    public List<ServiceDTO> getListAllServicesInBD() {
        return this.serviceRepository
                .findAll()
                .stream()
                .map(Service::toDTO)
                .collect(Collectors.toList());
    }

    public Service updateService(ServiceDTO serviceDTO, Integer id) {
        if (this.serviceRepository.existsById(id)) {
            if (this.checkServiceDTO(ServiceDTO
                    .builder()
                    .name(serviceDTO.getName())
                    .build())) {
                this.serviceRepository.getReferenceById(id).setName(serviceDTO.getName());
            }
            if (this.checkServiceDTO(ServiceDTO
                    .builder()
                    .baseAmount(serviceDTO.getBaseAmount())
                    .build())) {
                this.serviceRepository.getReferenceById(id).setBaseAmount(serviceDTO.getBaseAmount());
            }
            if (this.checkServiceDTO(ServiceDTO
                    .builder()
                    .monthlyCost(serviceDTO.getMonthlyCost())
                    .build())) {
                this.serviceRepository.getReferenceById(id).setMonthlyCost(serviceDTO.getMonthlyCost());
            }
            if (this.checkServiceDTO(ServiceDTO
                    .builder()
                    .supportChange(serviceDTO.getSupportChange())
                    .build())) {
                this.serviceRepository.getReferenceById(id).setSupportChange(serviceDTO.getSupportChange());
            }
            return this.serviceRepository.getReferenceById(id);
        }
        throw new NotUpdateException("Service doesn't exist");
    }
}
