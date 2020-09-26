package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public String list() {
        System.out.println("Retrieving the users");
        try {
            String result = userDao.findAll().toString();
            System.out.println(result);
            return "The result is" + result;
        } catch (Exception e) {
            System.out.println("The detail error message:" + e);
        }
        return "failed";
    }

    @GetMapping("/addusers")
    public String addUsers() {
        User user1 = new User("a", "aa", 1);
        userDao.save(user1);
        User user2 = new User("b", "bb", 2);
        userDao.save(user2);
        User user3 = new User("c", "cc", 3);
        userDao.save(user3);
        return "success";
    }
}