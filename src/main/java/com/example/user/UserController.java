package com.example.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value="/signup")
    public String signup(){
        return "signup";
    }

    @RequestMapping(value="/checkEmail", method = RequestMethod.GET)
    public ResponseEntity<?> checkEmail(@RequestParam("email") String email) {
        UserVO user = userServiceImpl.checkEmail(email);
        System.out.println(email);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("The email is allowed.");
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("The email is not allowed.");
        }
    }

    @RequestMapping(value="/signupOK", method = RequestMethod.POST)
    public String signupOK(UserVO vo){
        userServiceImpl.signup(vo);
        return "home";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/loginOK", method = RequestMethod.POST)
    public ResponseEntity<?> loginOK(@ModelAttribute UserVO vo) {
        UserVO user = userServiceImpl.login(vo);
        if(user == null){
            System.out.println("Controller return : null");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("login failed");
        }
        else {
            System.out.println("Controller return : OK");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("login succeed");
        }
    }
}
