package com.example.Payment.Project.Controller;

import com.example.Payment.Project.Model.User;
import com.example.Payment.Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody User user){
        User savedUser = userService.addUser(user);
        return new ResponseEntity(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/get-max-refund")
    public ResponseEntity getMaxRefund(){
        int id = userService.getMaxRefund();
        return new ResponseEntity(id, HttpStatus.FOUND);
    }
}
