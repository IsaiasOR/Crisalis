package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.EmptyElementException;
import com.Bootcamp.Crisalis.exception.custom.NotCreatedException;
import com.Bootcamp.Crisalis.exception.custom.UnauthorizedException;
import com.Bootcamp.Crisalis.model.Need;
import com.Bootcamp.Crisalis.model.dto.NeedDTO;
import com.Bootcamp.Crisalis.repository.NeedRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NeedService {
/*
    private final NeedRepository needRepository;

    public Need saveNeed(NeedDTO needDTO) {
        if (checkNeedDTO(needDTO)) {
            return this.needRepository.save(new Need(needDTO));
        }
        throw new NotCreatedException("Error in save new need");
    }

    private Boolean checkNeedDTO(NeedDTO needDTO) {
        if (StringUtils.isEmpty(needDTO.getName())) {
            throw new EmptyElementException("Name is empty");
        }
        if (ObjectUtils.isEmpty(needDTO.getBaseAmount())) {
            throw new EmptyElementException("Base amount is empty");
        }
        return Boolean.TRUE;
    }*/

/*    public Need deleteNeedByName(String name) {
        if (checkNeedDTO(NeedDTO
                .builder()
                .name(name)
                .build())) {
            return this.needRepository.deleteByName(name);
        }
        throw new NotEliminatedException("Error in deleting need");
    }*/

/*    public void deleteNeedById(Integer id) {
        this.needRepository.deleteById(id);
    }

    public Optional<Need> findNeedById(Integer id) {
        return this.needRepository.findById(id);
    }*/

/*    public NeedDTO findNeedByName(String name) {
        if (checkNeedDTO(NeedDTO
                .builder()
                .name(name)
                .build())) {
            return this.needRepository.findByName(name)
                    .orElseThrow(
                            () -> new UnauthorizedException("Need doesn't exist")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }*/

   /* public List<NeedDTO> getListAllNeedsInBD() {
        return this.needRepository
                .findAll()
                .stream()
                .map(Need::toDTO)
                .collect(Collectors.toList());
    }*/
}
