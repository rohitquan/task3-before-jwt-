package com.example.SecuritySpri.service;

import com.example.SecuritySpri.dto.UserDto;
import com.example.SecuritySpri.model.ModelUser;
import java.util.List;

public interface UserService {
    void createUser(UserDto userDto);
    List<ModelUser> getAllUsers();
    void changePassword(UserDto userDto);
    String verify(UserDto userDto);
}
