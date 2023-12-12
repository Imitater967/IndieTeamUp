package tech.spiritualdarkness.itu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.spiritualdarkness.itu.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
}
