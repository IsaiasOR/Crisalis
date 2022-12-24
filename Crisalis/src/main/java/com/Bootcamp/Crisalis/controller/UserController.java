package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.User;
import com.Bootcamp.Crisalis.model.dto.UserDTO;
import com.Bootcamp.Crisalis.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody UserDTO userDTO) {
        return this.userService.saveUser(userDTO);
    }

    @GetMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO loginUser(@RequestParam String email, @RequestParam String password) {
        return this.userService.loginUserWithCredentials(email, password);
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return this.userService.getListAllUsersInBD();
    }

    /*
    @GetMapping(value = "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@RequestParam String email, String password) {
        this.userService.deleteUser(email, password);
    }
    */
}