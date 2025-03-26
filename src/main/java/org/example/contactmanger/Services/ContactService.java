package org.example.contactmanger.Services;

import org.example.contactmanger.Repository.RepoConatct;
import org.example.contactmanger.Repository.RepoUser;
import org.example.contactmanger.model.Contact;
import org.example.contactmanger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
@Autowired
    private RepoConatct repoConatct;
@Autowired
private RepoUser repouser;
    public Contact deleteContact(int id) {
        return this.repoConatct.deleteById(id);
    }

    public Contact getContact(int id) {
        return this.repoConatct.getById(id);
    }
    public List<Contact> getAllContacts() {
        return this.repoConatct.findAll();
    }
    public Contact addContact(Contact contact) {
        Integer userId = contact.getUser().getId();  // Ensure user has an ID
        User user = repouser.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        contact.setUser(user);  // Assign the full User object
        return repoConatct.save(contact);
      //  return this.repoConatct.save(contact);
    }
}
