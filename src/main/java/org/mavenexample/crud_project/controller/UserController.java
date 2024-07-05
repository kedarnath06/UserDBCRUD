package org.mavenexample.crud_project.controller;

import org.mavenexample.crud_project.DTO.UserDTO;
import org.mavenexample.crud_project.entity.User;
import org.mavenexample.crud_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/save")
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/findAll")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findId")
    public UserDTO findById(@RequestParam int id) {
        return userService.findById(id);
    }

    @PutMapping("/update")
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        userService.delete(id);
    }
}
