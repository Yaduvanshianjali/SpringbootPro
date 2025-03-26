package org.example.contactmanger.Repository;

import org.example.contactmanger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RepoUser extends JpaRepository<User, Integer> {

    User findByName(String name);  // ✅ Corrected method name format

    List<User> findAll();  // ✅ This method is already provided by JpaRepository

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id = :id")  // ✅ Fixed DELETE query
    int deleteByid(@Param("id") int id);

    @Query("SELECT u FROM User u WHERE u.id = :id")  // ✅ Fixed SELECT query
    User getByid(@Param("id") int id);
}
