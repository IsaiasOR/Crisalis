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
        if (StringUtils.isEmpty(businessDTO.getCuit())) {
            throw new EmptyElementException("CUIT is empty");
        }
        if (StringUtils.isEmpty(businessDTO.getBusinessName())) {
            throw new EmptyElementException("Business name is empty");
        }
        if (ObjectUtils.isEmpty(businessDTO.getActStartDate())) {
            throw new EmptyElementException("Activities start date is empty");
        }
/*        if (ObjectUtils.isEmpty(businessDTO.getClients())) {
            throw new EmptyElementException("Client is empty");
        }*/
        return Boolean.TRUE;
    }

/*    public Optional<Business> deleteBusinessByCuit(String cuit) {
        if (StringUtils.isEmpty(cuit)) {
            throw new EmptyElementException("CUIT is empty");
        }
        return this.businessRepository.deleteByCuit(cuit);
    }*/

    public void deleteBusinessById(Integer id) {
        if (!this.businessRepository.existsById(id)) {
            throw new NotEliminatedException("Error in deleting business");
        }
        this.businessRepository.deleteById(id);
    }

    public Business findByCuit(String cuit) {
        if(StringUtils.isEmpty(cuit)) {
            throw new EmptyElementException("CUIT is empty");
        }
        return this.businessRepository.findByCuit(cuit)
                .orElseThrow(
                        () -> new UnauthorizedException("Business doesn't exist")
                );
    }

    public Business findBusinessById(Integer id) {
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
        Business newBusiness = businessRepository.getReferenceById(id);

        if (this.businessRepository.existsById(id)) {
            if (!StringUtils.isEmpty(businessDTO.getBusinessName())) {
                newBusiness.setBusinessName(businessDTO.getBusinessName());
            }
            if (!StringUtils.isEmpty(businessDTO.getCuit())) {
                newBusiness.setCuit(businessDTO.getCuit());
            }
            if (!ObjectUtils.isEmpty(businessDTO.getActStartDate())) {
                newBusiness.setActStartDate(businessDTO.getActStartDate());
            }
            return this.businessRepository.save(newBusiness);
        }
        throw new NotUpdateException("Business doesn't exist");
    }
}
