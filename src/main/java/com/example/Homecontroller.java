package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Homecontroller {
    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
