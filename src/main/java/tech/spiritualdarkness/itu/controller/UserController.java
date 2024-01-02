package tech.spiritualdarkness.itu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.spiritualdarkness.itu.bean.po.User;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.bean.vo.response.UserResultStatus;
import tech.spiritualdarkness.itu.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/register")
    public Result<User, UserResultStatus> register(@RequestParam String username
            , @RequestParam String password){
        if(username == null || password ==null){
            return null;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.register(user);
    }

    @GetMapping("/login")
    public Result<User, UserResultStatus> login(@RequestParam String username
            , @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.login(user);
    }

}
