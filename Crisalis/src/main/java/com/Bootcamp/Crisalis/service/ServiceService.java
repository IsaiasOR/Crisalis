package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.enums.TypeService;
import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.Service;
import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
import com.Bootcamp.Crisalis.model.dto.ServiceItemDTO;
import com.Bootcamp.Crisalis.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
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
        if (ObjectUtils.isEmpty(serviceDTO.getTypeService())) {
            throw new EmptyElementException("Type service is empty");
        }
        if (serviceDTO.getTypeService() == TypeService.COMMON &&
        !ObjectUtils.isEmpty(serviceDTO.getSupportChange())) {
            throw new EmptyElementException("Type service is common");
        }
        if (serviceDTO.getTypeService() == TypeService.SPECIAL &&
                ObjectUtils.isEmpty(serviceDTO.getSupportChange())) {
            throw new EmptyElementException("Support change is empty");
        }
        return Boolean.TRUE;
    }

    public void deleteServiceById(Integer id) {
        if (!this.serviceRepository.existsById(id)) {
            throw new NotEliminatedException("Service doesn't exist");
        }
        this.serviceRepository.deleteById(id);
    }

    public Optional<Service> findServiceById(Integer id) {
        if (this.serviceRepository.existsById(id)) {
            return this.serviceRepository.findById(id);
        }
        throw new NotEliminatedException("Service doesn't exist");

//            return this.serviceRepository.findById(id)
//                    .orElseThrow(
//                            () -> new UnauthorizedException("Service doesn't exist")
//                    );
    }

    public List<ServiceItemDTO> getListAllServicesInBD() {
        return this.serviceRepository
                .findAll()
                .stream()
                .map(Service::toServiceItemDTO)
                .collect(Collectors.toList());
    }

    public Service updateService(ServiceDTO serviceDTO, Integer id) {
        Service newService = serviceRepository.getReferenceById(id);

        if (this.serviceRepository.existsById(id)) {
            if (!StringUtils.isEmpty(serviceDTO.getName())) {
                newService.setName(serviceDTO.getName());
            }
            if (!ObjectUtils.isEmpty(serviceDTO.getBaseAmount())) {
                newService.setBaseAmount(serviceDTO.getBaseAmount());
            }
            if (!ObjectUtils.isEmpty(serviceDTO.getSupportChange())) {
                newService.setSupportChange(serviceDTO.getSupportChange());
            }
            if (!ObjectUtils.isEmpty(serviceDTO.getTypeService())){
                newService.setTypeService(serviceDTO.getTypeService());
            }
            return this.serviceRepository.save(newService);
        }
        throw new NotUpdateException("Service doesn't exist");
    }

    public List<Service> getAllServicesCompleteInBD() {
        return this.serviceRepository.findAll();
    }
}
