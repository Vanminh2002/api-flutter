package org.example.apiflutter.controller;

import jakarta.validation.Valid;
import org.example.apiflutter.dto.request.UserDto;
import org.example.apiflutter.dto.request.UserUpdateDto;
import org.example.apiflutter.entity.User;
import org.example.apiflutter.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired

    private UserServices userServices;

    @PostMapping
    User create(@Valid @RequestBody UserDto userDto) {
        return userServices.createRequest(userDto);
    }

    @GetMapping
    List<User> getAll() {
        return userServices.getAll();
    }


    @GetMapping("/{id}")
    User getById(@PathVariable String id) {
        return userServices.getById(id);
    }

    @PutMapping("/{id}")
    User update(@PathVariable String id, @RequestBody UserUpdateDto userUpdateDto) {

        return userServices.update(userUpdateDto, id);
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable String id) {
        userServices.delete(id);
        return "User has been deleted";
    }
}
