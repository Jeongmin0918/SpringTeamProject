package com.example.user;

import com.example.market.MarketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserVO checkEmail(String email){
        String sql = "select * from users where email = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(), email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public UserVO login(UserVO vo){
        String sql = "select * from users where email = ? and password = HEX(AES_ENCRYPT(?, SHA2('encrypt-key', 512)))";
        try {
            System.out.println("Something");
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(), vo.getEmail(), vo.getPassword());
        } catch (EmptyResultDataAccessException e) {
            System.out.println("NULL");
            return null;
        }
    }

    public int signup(UserVO vo){
        String sql = "insert into users (email, password) values("
                + "'" + vo.getEmail() + "',"
                + "'" + vo.getPassword() + "')";
        return jdbcTemplate.update(sql);
    }

    class UserRowMapper implements RowMapper<UserVO> {
        @Override
        public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserVO vo = new UserVO();
            vo.setEmail(rs.getString("email"));
            vo.setPassword(rs.getString("password"));
            return vo;
        }
    }
}
