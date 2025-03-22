package com.example.demo.Service;

import com.example.demo.model.User;
import com.example.demo.repository.userJparepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Ensures Spring creates a bean
public class UserServiceImpl implements UserService {

    @Autowired
    private userJparepo repos;

    @Override
    public List<User> getAlluser() {
        return this.repos.getUsers(); // Ensure this method exists in userJparepo
    }
}
