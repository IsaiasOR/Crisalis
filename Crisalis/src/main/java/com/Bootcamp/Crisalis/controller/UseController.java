package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.User;
import com.Bootcamp.Crisalis.model.dto.UserDTO;
import com.Bootcamp.Crisalis.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UseController {

    /* Inyección de dependencia: es poder contar con un único objeto, el cuál se instancia una única vez a
    nivel constructor y no estar instanciando objetos de userService por cada uno de los métodos que
    utilicemos (singleton)
     */
    private final UserService userService;

    public UseController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody UserDTO userDTO) {
        return this.userService.saveUser(userDTO);
    }

    //Recibirá a los parámetros dentro de la dirección
    @GetMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO loginUser(@RequestParam String email, @RequestParam String password) {
        return this.userService.loginUserWithCredentials(email, password);
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return this.userService.getListAllUsersInBD();
    }
}
