package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    UserDAO userDAO;

    public int signup(UserVO vo){
        return userDAO.signup(vo);
    }

    public UserVO checkEmail(String email){
        return userDAO.checkEmail(email);
    }
    public UserVO login(UserVO vo){
        return userDAO.login(vo);
    }

}
