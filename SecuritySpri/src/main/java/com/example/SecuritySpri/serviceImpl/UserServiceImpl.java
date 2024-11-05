package com.example.SecuritySpri.serviceImpl;

import com.example.SecuritySpri.dto.UserDto;
import com.example.SecuritySpri.model.ModelUser;
import com.example.SecuritySpri.repository.UserRepository;
import com.example.SecuritySpri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userDto);
    }

    @Override
    public List<ModelUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void changePassword(UserDto userDto) {
        userRepository.updatePassword(userDto);
    }

    @Override
    public String verify(UserDto userDto) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        } catch (AuthenticationException e) {
            return "Fail";
        }
        return authentication.isAuthenticated() ? jwtService.generatedToken() : "Fail";
    }

}
