package com.mrdb.controller;

import com.mrdb.entities.UserEntity;
import com.mrdb.entities.UserEntityRepository;
import com.mrdb.model.GetAndSetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class MainController {
    @Autowired private UserEntityRepository repo;
    private GetAndSetData getAndSetData;

    @PostMapping("/login")
    public String login(@RequestBody UserEntity userDetails) {
        getAndSetData = new GetAndSetData(repo);
        if(getAndSetData.login(userDetails)) {
            return "Success";
        }
        return "fail";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserEntity userDetails) {
        getAndSetData = new GetAndSetData(repo);
        return getAndSetData.saveToDb(userDetails);
    }
}
