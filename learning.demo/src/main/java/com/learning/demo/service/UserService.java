package com.learning.demo.service;

import com.learning.demo.entities.User;
import com.learning.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User addUser(User user){
        userRepo.save(user);
        return user;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

}
