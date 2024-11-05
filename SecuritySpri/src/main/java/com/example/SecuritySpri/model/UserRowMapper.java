package com.example.SecuritySpri.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<ModelUser> {

    @Override
    public ModelUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        ModelUser user=new ModelUser();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
