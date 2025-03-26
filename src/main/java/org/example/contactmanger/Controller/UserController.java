package org.example.contactmanger.Controller;

import org.example.contactmanger.Services.UserService;
import org.example.contactmanger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/User")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getall")
public List<User> AddUser() {
       // List<User> users = new ArrayList<User>();
        List<User> users = this.userService.getusers();
    return users;
}
    @PostMapping(value = "/Add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        System.out.println(user);
        System.out.println("check it");
        if (user.getPhone() == null) {
            return ResponseEntity.badRequest().build();
        }

        if (user == null || user.getName()==null || user.getEmail() == null||user.getUsername()==null) {
            return ResponseEntity.badRequest().build(); // Returns HTTP 400 Bad Request
        }
        User savedUser = this.userService.addUser(user); // Make sure the method name matches in UserService
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public int DeleteUser(@PathVariable Integer id) {
        return this.userService.deleteuser(id);
}
@GetMapping("/Getuser/{id}")
    public User GetUser(@PathVariable Integer id) {
        User user = this.userService.getUser(id);
        return user;
}


}
