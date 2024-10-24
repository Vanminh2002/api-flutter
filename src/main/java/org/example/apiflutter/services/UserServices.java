package org.example.apiflutter.services;

import org.example.apiflutter.dto.request.UserDto;
import org.example.apiflutter.dto.request.UserUpdateDto;
import org.example.apiflutter.entity.User;
import org.example.apiflutter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    //Create
    public User createRequest(UserDto userDto) {
        User user = new User();

        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new RuntimeException("User Existed");
        }
//        if(user != null){
//            throw  new RuntimeException("User Existed");
//        }

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setDob(userDto.getDob());

        return userRepository.save(user);
    }

    // Get All
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // GetById
    public User getById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
    }

    // Update
    public User update(UserUpdateDto userDto, String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setDob(userDto.getDob());

        return userRepository.save(user);
    }

    // Delete
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
