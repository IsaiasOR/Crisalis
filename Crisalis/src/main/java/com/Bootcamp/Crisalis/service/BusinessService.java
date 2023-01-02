package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.EmptyElementException;
import com.Bootcamp.Crisalis.exception.custom.NotCreatedException;
import com.Bootcamp.Crisalis.exception.custom.NotEliminatedException;
import com.Bootcamp.Crisalis.exception.custom.UnauthorizedException;
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
        return Boolean.TRUE;
    }

    public Business deleteBusiness(Integer cuit) {
        if (checkBusinessDTO(BusinessDTO
                .builder()
                .cuit(cuit)
                .build())) {
            return this.businessRepository.deleteByCuit(cuit);
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
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    public List<BusinessDTO> getListAllBusinessInBD() {
        return this.businessRepository
                .findAll()
                .stream()
                .map(Business::toDTO)
                .collect(Collectors.toList());
    }
}
