package org.mavenexample.crud_project.service;

import org.mavenexample.crud_project.DTO.UserDTO;
import org.mavenexample.crud_project.Mapper.UserMapper;
import org.mavenexample.crud_project.Repository.UserRepository;
import org.mavenexample.crud_project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO saveUser(UserDTO userDTO){
        User user1 = UserMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user1);
        return UserMapper.toDTO(savedUser);
    }

    public UserDTO findById(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) throw new RuntimeException("User Not Found");
        return  UserMapper.toDTO(user.get());
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO update(UserDTO userDTO) {
        Optional<User> dbuser = userRepository.findById(userDTO.getId());

        if (dbuser.isEmpty()){
            throw new RuntimeException("User Not Found");
        }

        User existingUser = dbuser.get();
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        User savedUser = userRepository.save(existingUser);
        return UserMapper.toDTO(savedUser);

    }

    public void delete(int id) {
        Optional<User> dbuser = userRepository.findById(id);

        if (dbuser.isEmpty()){
            throw new RuntimeException("User Not Found");
        }

        userRepository.delete(dbuser.get());
    }






}
