package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.EmptyElementException;
import com.Bootcamp.Crisalis.exception.custom.NotCreatedException;
import com.Bootcamp.Crisalis.exception.custom.NotEliminatedException;
import com.Bootcamp.Crisalis.exception.custom.UnauthorizedException;
import com.Bootcamp.Crisalis.model.Tax;
import com.Bootcamp.Crisalis.model.dto.TaxDTO;
import com.Bootcamp.Crisalis.repository.TaxRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaxService {

    private final TaxRepository taxRepository;

    public Tax saveTax(TaxDTO taxDTO) {
        if (checkTaxDTO(taxDTO)) {
            return this.taxRepository.save(new Tax(taxDTO));
        }
        throw new NotCreatedException("Error in save new tax");
    }

    public Boolean checkTaxDTO(TaxDTO taxDTO) {
        if (StringUtils.isEmpty(taxDTO.getName())) {
            throw new EmptyElementException("Name tax is empty");
        }
        if (ObjectUtils.isEmpty(taxDTO.getPercentage())) {
            throw new EmptyElementException("Amount is empty");
        }
        return Boolean.TRUE;
    }


    public Tax deleteTaxByName(String name) {
        if (checkTaxDTO(TaxDTO
                .builder()
                .name(name)
                .build())) {
            return this.taxRepository.deleteByName(name);
        }
        throw new NotEliminatedException("Error in deleting tax");
    }


    public void deleteTaxById(Integer id) {
        this.taxRepository.deleteById(id);
    }

    public TaxDTO findByName(String name) {
        if (this.checkTaxDTO(TaxDTO
                        .builder()
                        .name(name)
                        .build())) {
            return this.taxRepository.findByName(name)
                    .orElseThrow(
                            () -> new UnauthorizedException("Invalid credentials")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    public List<TaxDTO> getListAllTaxesInBD() {
        return this.taxRepository
                .findAll()
                .stream()
                .map(Tax::toDTO)
                .collect(Collectors.toList());
    }
}
