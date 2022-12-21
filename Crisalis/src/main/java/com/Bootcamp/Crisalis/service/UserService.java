package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.EmptyElementException;
import com.Bootcamp.Crisalis.exception.custom.NotCreatedException;
import com.Bootcamp.Crisalis.exception.custom.UnauthorizedException;
import com.Bootcamp.Crisalis.model.User;
import com.Bootcamp.Crisalis.model.dto.UserDTO;
import com.Bootcamp.Crisalis.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDTO userDTO) {
        if(checkUserDTO(userDTO, Boolean.FALSE)) {
           return this.userRepository.save(new User((userDTO)));
        }
        throw new NotCreatedException("Error in save new User");
    }

    //Necesario el chech de userDTO
    public UserDTO loginUserWithCredentials(String email, String password) {
        if (
                this.checkUserDTO(UserDTO
                                .builder()
                                .email(email)
                                .password(password)
                                .build()
                        ,Boolean.TRUE)
        ) {
            return this.userRepository.findByUsernameAndPassword(email, password)
                    .orElseThrow(
                            //Es como hacer un método y llamarlo directamente
                            () -> new UnauthorizedException("Invalid credentials")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    //Mapeo de todo a DTO
    public List<UserDTO> getListAllUsersInBD() {
        return this.userRepository
                .findAll()
                .stream()
                .map(User::toDTO)
                .collect(Collectors.toList());
    }

    //Colocar lo necesario para logear
    public Boolean checkUserDTO(UserDTO userDTO, Boolean isForLogin) {
        //Si es para logear, es decir, es true entonces no controlará lo de adentro
        if(!isForLogin) {
            if(StringUtils.isEmpty(userDTO.getEmail())) {
                throw new EmptyElementException("Email is empty");
            }
            if(StringUtils.isEmpty(userDTO.getFirstName())) {
                throw new EmptyElementException("First name is empty");
            }
            if(StringUtils.isEmpty(userDTO.getLastName())) {
                throw new EmptyElementException("Last name is empty");
            }
            if(userDTO.getUserRole() == null) {
                throw new EmptyElementException("Role is empty");
            }
        }
        if(StringUtils.isEmpty(userDTO.getEmail())) {
            throw new EmptyElementException("Username is empty");
        }
        if(StringUtils.isEmpty(userDTO.getPassword())) {
            throw new EmptyElementException("Password is empty");
        }
        return Boolean.TRUE;
    }
}
