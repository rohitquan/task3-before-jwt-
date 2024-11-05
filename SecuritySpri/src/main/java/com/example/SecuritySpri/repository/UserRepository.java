package com.example.SecuritySpri.repository;

import com.example.SecuritySpri.dto.UserDto;
import com.example.SecuritySpri.model.ModelUser;

import java.util.List;

public interface UserRepository {
    void save(UserDto userDto);
    List<ModelUser> findAll();
    ModelUser findByUsername(String username);
    void updatePassword(UserDto userDto);
}
