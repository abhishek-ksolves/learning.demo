package com.learning.demo.seed;

import com.learning.demo.entities.Address;
import com.learning.demo.entities.User;
import com.learning.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Seed {

    @Autowired
    private UserService userService;

    @PostConstruct
    private void addUser() {
        userService.addUser(new User(null, "Default", "deafult@d.com", 20, "@qwertt", new Address(null, "BCD", "DEF", "ABC")));
    }
}
