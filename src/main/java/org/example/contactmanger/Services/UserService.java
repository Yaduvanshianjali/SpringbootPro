package org.example.contactmanger.Services;

import org.example.contactmanger.Repository.RepoConatct;
import org.example.contactmanger.Repository.RepoUser;
import org.example.contactmanger.model.Contact;
import org.example.contactmanger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private RepoUser repo;
    @Autowired
    private RepoConatct repoConatct;
public User addUser(User user) {
   // List<Contact> contacts = repoConatct.findAllById(user.getContacts().get);
    List<Integer> contactIds = user.getContacts().stream()
            .map(Contact::getId)
            .collect(Collectors.toList());

    List<Contact> contacts = repoConatct.findAllById(contactIds);

    user.setContacts(contacts);  // Assuming User has a List<Contact> contacts;
 //   return repo.save(user);
    return this.repo.save(user);
}


    public List<User> getusers() {
    return this.repo.findAll();
    }

    public int  deleteuser(Integer id) {
    return this.repo.deleteByid(id);
    }

    public User getUser(Integer id) {
    return this.repo.getByid(id);
    }

}
