package edu.example.service.impl;

import edu.example.model.dto.LoginRequestDto;
import edu.example.model.dto.UserDto;
import edu.example.model.entity.User;
import edu.example.repository.UserRepository;
import edu.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(LoginRequestDto loginRequest) {
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();


            if (user.getEmail().equalsIgnoreCase(loginRequest.getEmail())) {


                if (user.getRoles() == null || user.getRoles().isEmpty()) {
                    return "ROLE_USER";
                }

                return user.getRoles().stream()
                        .map(role -> role.getName())
                        .findFirst()
                        .orElse("ROLE_USER");
            } else {
                return "INVALID_EMAIL";
            }
        }
        return "USER_NOT_FOUND";
    }

    @Override
    public UserDto register(UserDto userDto) {
        User userEntity = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(userEntity);
        return modelMapper.map(savedUser, UserDto.class);
    }
}