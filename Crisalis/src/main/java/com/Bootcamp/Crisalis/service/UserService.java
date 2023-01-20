package com.Bootcamp.Crisalis.service;

import com.Bootcamp.Crisalis.exception.custom.*;
import com.Bootcamp.Crisalis.model.User;
import com.Bootcamp.Crisalis.model.dto.UserDTO;
import com.Bootcamp.Crisalis.repository.UserRepository;
import com.Bootcamp.Crisalis.security.EmailValidator;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EmailValidator emailValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(UserDTO userDTO) {
        //Varificación de email
        boolean isValidEmail = emailValidator.test(userDTO.getEmail());
        if(!isValidEmail) {
          throw new IllegalStateException("Email not valid");
        }

        //Verificación de si existe el usuario
        boolean userExists = userRepository.findByEmail(userDTO.getEmail()).isPresent();
        if (userExists) {
            throw new IllegalStateException("Email already taken");
        }

        //Codificación de la contraseña
        String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);

        //Check User
        if(checkUserDTO(userDTO, Boolean.FALSE)) {
           return this.userRepository.save(new User((userDTO)));
        }
        throw new NotCreatedException("Error in save new user");
    }

    public UserDTO loginUserWithCredentials(String email, String password) {
        if (
                this.checkUserDTO(UserDTO
                                .builder()
                                .email(email)
                                .password(password)
                                .build()
                        ,Boolean.TRUE)
        ) {
            return this.userRepository.findByEmailAndPassword(email, password)
                    .orElseThrow(
                            () -> new UnauthorizedException("Invalid credentials")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    public List<UserDTO> getListAllUsersInBD() {
        return this.userRepository
                .findAll()
                .stream()
                .map(User::toDTO)
                .collect(Collectors.toList());
    }

    public Boolean checkUserDTO(UserDTO userDTO, Boolean isForLogin) {
        //Si es para logear, es decir es true, entonces no controlará lo de adentro
        if(!isForLogin) {
            if(StringUtils.isEmpty(userDTO.getEmail())) {
                throw new EmptyElementException("Email is empty");
            }
            if(StringUtils.isEmpty(userDTO.getPassword())) {
                throw new EmptyElementException("Password is empty");
            }
            if(StringUtils.isEmpty(userDTO.getFirstName())) {
                throw new EmptyElementException("First name is empty");
            }
            if(StringUtils.isEmpty(userDTO.getLastName())) {
                throw new EmptyElementException("Last name is empty");
            }
            if(ObjectUtils.isEmpty(userDTO.getDni())) {
                throw new EmptyElementException("DNI is empty");
            }
            if(StringUtils.isEmpty(userDTO.getPhoneNumber())) {
                throw new EmptyElementException("Mobile number phone is empty");
            }
            if(ObjectUtils.isEmpty(userDTO.getUserRole())) {
                throw new EmptyElementException("Role is empty");
            }
        }
        if(StringUtils.isEmpty(userDTO.getEmail())) {
            throw new EmptyElementException("Email is empty");
        }
        if(StringUtils.isEmpty(userDTO.getPassword())) {
            throw new EmptyElementException("Password is empty");
        }
        return Boolean.TRUE;
    }

    public User deleteUserByDni(Integer dni) {
        if (checkUserDTO(UserDTO
                .builder()
                .dni(dni)
                .build(), Boolean.FALSE)) {
            return this.userRepository.deleteByDni(dni);
        }
        throw new NotEliminatedException("Error in deleting user");
    }

    public UserDTO findByDni(Integer dni) {
        if (
                this.checkUserDTO(UserDTO
                                .builder()
                                .dni(dni)
                                .build()
                        ,Boolean.FALSE)
        ) {
            return this.userRepository.findByDni(dni)
                    .orElseThrow(
                            () -> new UnauthorizedException("User doesn't exist")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    public User deleteUserById(Integer id) {
        if (this.userRepository.existsById(id)) {
            return this.userRepository.deleteUserById(id);
        }
        throw new NotEliminatedException("Error in deleting user");
    }

    public UserDTO findById(Integer id) {
        if (this.userRepository.existsById(id)) {
            return this.userRepository.findUserById(id);
        }
        throw new UnauthorizedException("User doesn't exist");
    }

    public User updateUser(UserDTO userDTO, Integer id) {
        if (this.userRepository.existsById(id)) {
            if (this.checkUserDTO(UserDTO
                    .builder()
                    .dni(userDTO.getDni())
                    .build(), Boolean.FALSE)) {
                this.userRepository.getReferenceById(id).setDni(userDTO.getDni());
            }
            if (this.checkUserDTO(UserDTO
                    .builder()
                    .firstName(userDTO.getFirstName())
                    .build(), Boolean.FALSE)) {
                this.userRepository.getReferenceById(id).setFirstName(userDTO.getFirstName());
            }
            if (this.checkUserDTO(UserDTO
                    .builder()
                    .lastName(userDTO.getLastName())
                    .build(), Boolean.FALSE)) {
                this.userRepository.getReferenceById(id).setLastName(userDTO.getLastName());
            }
            if (this.checkUserDTO(UserDTO
                    .builder()
                    .email(userDTO.getEmail())
                    .build(), Boolean.FALSE)) {
                this.userRepository.getReferenceById(id).setEmail(userDTO.getEmail());
            }
            if (this.checkUserDTO(UserDTO
                    .builder()
                    .phoneNumber(userDTO.getPhoneNumber())
                    .build(), Boolean.FALSE)) {
                this.userRepository.getReferenceById(id).setPhoneNumber(userDTO.getPhoneNumber());
            }
            if (this.checkUserDTO(UserDTO
                    .builder()
                    .password(userDTO.getPassword())
                    .build(), Boolean.FALSE)) {
                this.userRepository.getReferenceById(id).setPassword(userDTO.getPassword());
            }
            if (this.checkUserDTO(UserDTO
                    .builder()
                    .userRole(userDTO.getUserRole())
                    .build(), Boolean.FALSE)) {
                this.userRepository.getReferenceById(id).setUserRole(userDTO.getUserRole());
            }
            if (this.checkUserDTO(UserDTO
                    .builder()
                    .orders(userDTO.getOrders())
                    .build(), Boolean.FALSE)) {
                this.userRepository.getReferenceById(id).setOrders(userDTO.getOrders());
            }
        }
        throw new NotUpdateException("User doesn't exist");
    }
}
