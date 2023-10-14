package com.luoying.controller;

import com.luoying.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/hh")
    public String test(HttpServletRequest request,Integer age){
        System.out.println(request.getHeader("username"));
        return request.getHeader("username")+age;
    }
    @PostMapping("/")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        return "post 你的用户名：" + user.getUsername();
    }
}
