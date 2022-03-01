package com.mrdb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mrdb.entities.UserEntity;
import com.mrdb.entities.UserEntityRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/users")
public class MainController {
    @Autowired private UserEntityRepository repo;

    @PostMapping("/login")
    public String login(@RequestBody UserEntity userDetails) {
        String res = "Ok";
        String userName = userDetails.getUserName();
        String password = userDetails.getPassword();
        UserEntity user = repo.findByUserName(userName);
        if(null != user && password.equalsIgnoreCase(user.getPassword())) {
            res = "Ok";
        } else {
            res = "Not Ok";
        }

        return res;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserEntity userDetails) {
        String res = "Ok";
        try {
            repo.save(userDetails);
        } catch (Exception e) {
            e.printStackTrace();
            res = "problem";
        }
        return res;
    }
}