package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.User;
import com.Bootcamp.Crisalis.model.dto.UserDTO;
import com.Bootcamp.Crisalis.model.dto.UserItemDTO;
import com.Bootcamp.Crisalis.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"localhost:8080", "localhost", "http://localhost:4200"})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody UserDTO userDTO) {
        return this.userService.saveUser(userDTO);
    }

    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(
                this.userService.loginUserWithCredentials(
                        userDTO.getEmail(), userDTO.getPass()));
    }

    @GetMapping(value = "/list")
    public List<UserItemDTO> getAllUsers() {
        return this.userService.getListAllUsersInBD();
    }

    @GetMapping(value = "/listComplete")
    public List<User> getAllUsersCompleteInBD() {
        return this.userService.getAllUsersCompleteInBD();
    }

/*    @DeleteMapping(value = "/deleteByDni/{dni}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteUserByDni(@PathVariable("dni") Integer dni) {
        return this.userService.deleteUserByDni(dni);
    }*/

    @DeleteMapping(value = "/deleteById/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        String msj = "Removal successful";
        this.userService.deleteUserById(id);
        return msj;
    }

    @GetMapping(value = "/findUserByDni/{dni}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO findUserByDni(@PathVariable("dni") Integer dni) {
        return this.userService.findByDni(dni);
    }

    @GetMapping(value = "/findUserById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User findUser(@PathVariable("id") Integer id) {
        return this.userService.findById(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Integer id) {
        return this.userService.updateUser(userDTO, id);
    }
}
