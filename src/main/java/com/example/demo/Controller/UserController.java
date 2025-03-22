package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService UserService;

    @GetMapping("/all")
    public List<User> getUsers() {
       // ModelAndView mv = new ModelAndView("allUsers"); // View name
        List<User> users = this.UserService.getAlluser(); // Corrected method name
     //   mv.addObject("users", users); // Corrected method call
        return users;
    }
}
