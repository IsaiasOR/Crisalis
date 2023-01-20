package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.Business;
import com.Bootcamp.Crisalis.model.dto.BusinessDTO;
import com.Bootcamp.Crisalis.repository.BusinessRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BusinessService {

    private BusinessRepository businessRepository;

    public Business saveBusiness(BusinessDTO businessDTO) {
        if (checkBusinessDTO(businessDTO)) {
            return this.businessRepository.save(new Business(businessDTO));
        }
        throw new NotCreatedException("Error in save new business");
    }

    public Boolean checkBusinessDTO(BusinessDTO businessDTO) {
        if (ObjectUtils.isEmpty(businessDTO.getCuit())) {
            throw new EmptyElementException("CUIT is empty");
        }
        if (StringUtils.isEmpty(businessDTO.getBusinessName())) {
            throw new EmptyElementException("Business name is empty");
        }
        if (ObjectUtils.isEmpty(businessDTO.getActStartDate())) {
            throw new EmptyElementException("Activities start date is empty");
        }
        if (ObjectUtils.isEmpty(businessDTO.getClients())) {
            throw new EmptyElementException("Client is empty");
        }
        return Boolean.TRUE;
    }

    public Business deleteBusinessByCuit(Integer cuit) {
        if (checkBusinessDTO(BusinessDTO
                .builder()
                .cuit(cuit)
                .build())) {
            return this.businessRepository.deleteByCuit(cuit);
        }
        throw new NotEliminatedException("Error in deleting client");
    }

    public Business deleteBusinessById(Integer id) {
        if (this.businessRepository.existsById(id)) {
            return this.businessRepository.deleteBusinessById(id);
        }
        throw new NotEliminatedException("Error in deleting client");
    }

    public BusinessDTO findByCuit(Integer cuit) {
        if (
                this.checkBusinessDTO(BusinessDTO
                        .builder()
                        .cuit(cuit)
                        .build())
        ) {
            return this.businessRepository.findByCuit(cuit)
                    .orElseThrow(
                            () -> new UnauthorizedException("Business doesn't exist")
                    );
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    public BusinessDTO findBusinessById(Integer id) {
        if (this.businessRepository.existsById(id)) {
            return this.businessRepository.findBusinessById(id);
        }
        throw new UnauthorizedException("Business doesn't exist");
    }

    public List<BusinessDTO> getListAllBusinessInBD() {
        return this.businessRepository
                .findAll()
                .stream()
                .map(Business::toDTO)
                .collect(Collectors.toList());
    }

    public Business updateBusiness(BusinessDTO businessDTO, Integer id) {
        if (this.businessRepository.existsById(id)) {
            if (checkBusinessDTO(BusinessDTO
                    .builder()
                    .businessName(businessDTO.getBusinessName())
                    .build())) {
                this.businessRepository.getReferenceById(id).setBusinessName(businessDTO.getBusinessName());
            }
            if (checkBusinessDTO(BusinessDTO
                    .builder()
                    .cuit(businessDTO.getCuit())
                    .build())) {
                this.businessRepository.getReferenceById(id).setCuit(businessDTO.getCuit());
            }
            if (checkBusinessDTO(BusinessDTO
                    .builder()
                    .actStartDate(businessDTO.getActStartDate())
                    .build())) {
                this.businessRepository.getReferenceById(id).setActStartDate(businessDTO.getActStartDate());
            }
            if (checkBusinessDTO(BusinessDTO
                    .builder()
                    .clients(businessDTO.getClients())
                    .build())) {
                this.businessRepository.getReferenceById(id).setClients(businessDTO.getClients());
            }
            return this.businessRepository.getReferenceById(id);
        }
        throw new NotUpdateException("Business doesn't exist");
    }
}
