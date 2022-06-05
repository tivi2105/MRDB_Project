package com.mrdb.model;

import com.mrdb.entities.Movies;
import com.mrdb.entities.UserEntity;
import com.mrdb.repositories.MoviesRepository;
import com.mrdb.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GetAndSetData {

    @Autowired
    private UserEntityRepository userRepo;

    public GetAndSetData(UserEntityRepository userRepo){
        this.userRepo = userRepo;
    }


    public String saveToDb(UserEntity userDetails) {
        String result = "Success";
        try {
            if(checkEmail(userDetails)) {
                result = "Email exist, please login";
            } else if(checkUserName(userDetails)) {
                result = "User name already exist, please login";
            } else {
                userRepo.save(userDetails);
            }
        } catch (Exception e) {
            result = "problem";
            e.printStackTrace();
        }
        return result;
    }

    public boolean login(UserEntity userDetails) {
        if(null == userDetails) {
            return false;
        }
        List<UserEntity> user = new ArrayList<>();
        try {
            user.addAll(userRepo.findByUserNameAndPassword(userDetails.getUserName(), userDetails.getPassword()));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return user.size() != 0;
    }

    public boolean checkEmail(UserEntity userDetails) {
        if(null == userDetails) {
            return false;
        }
        List<UserEntity> user = new ArrayList<>();;
        try {
            user.addAll(userRepo.findByEmail(userDetails.getEmail()));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return user.size() != 0;
    }

    public boolean checkUserName(UserEntity userDetails) {
        if(null == userDetails) {
            return false;
        }
        List<UserEntity> user = new ArrayList<>();
        try {
            user.addAll(userRepo.findByEmail(userDetails.getUserName()));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return user.size() != 0;
    }

}
