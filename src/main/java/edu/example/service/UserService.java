package edu.example.service;

import edu.example.model.dto.LoginRequestDto;
import edu.example.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String login(LoginRequestDto loginRequest);

    UserDto register(UserDto userDto);

}
