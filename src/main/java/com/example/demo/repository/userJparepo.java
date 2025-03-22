package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userJparepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u") // JPQL query (works with entity classes)
    List<User> getUsers();



    // If you want a native SQL query, use this:
    // @Query(value = "SELECT * FROM users", nativeQuery = true)
    // List<User> getUsers();
}
