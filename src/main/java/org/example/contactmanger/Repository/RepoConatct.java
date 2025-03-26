package org.example.contactmanger.Repository;

import org.example.contactmanger.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RepoConatct extends JpaRepository<Contact, Integer> {

    // ✅ Correct delete query
    @Modifying
    @Transactional
    @Query("DELETE FROM Contact c WHERE c.id = :id")
    Contact deleteById(int id);

    // ✅ Correct getById query
    @Query("SELECT u FROM Contact u WHERE u.id = :id")
    Contact getById(int id);
}
