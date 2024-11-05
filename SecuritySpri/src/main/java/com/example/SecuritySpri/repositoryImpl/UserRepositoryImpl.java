package com.example.SecuritySpri.repositoryImpl;

import com.example.SecuritySpri.dto.UserDto;
import com.example.SecuritySpri.model.ModelUser;
import com.example.SecuritySpri.model.UserRowMapper;
import com.example.SecuritySpri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(UserDto userDto) {
        String sql = "INSERT INTO users (username, password) VALUES (?,?)";
        jdbcTemplate.update(sql,userDto.getUsername(),userDto.getPassword());
    }

    @Override
    public List<ModelUser> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql,new UserRowMapper());
    }

    @Override
    public ModelUser findByUsername(String username) {
        String sql= "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);
    }

    @Override
    public void updatePassword(UserDto userDto) {
        String sql = "UPDATE users SET password = ? WHERE username = ?";
        jdbcTemplate.update(sql, userDto.getUsername(), userDto.getPassword());
    }


}
