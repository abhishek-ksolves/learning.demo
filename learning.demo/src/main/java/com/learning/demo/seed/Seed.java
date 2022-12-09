package com.learning.demo.seed;

import com.learning.demo.entities.Address;
import com.learning.demo.entities.User;
import com.learning.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Seed {

    Logger logger = LoggerFactory.getLogger(Seed.class);



    @Autowired
    private UserService userService;

    @PostConstruct
    private void addUser() {
        logger.trace("User has been created");
        userService.addUser(new User(null, "Default", "deafult@d.com", 20, "@qwertt", new Address(null, "BCD", "DEF", "ABC")));
    }
}
