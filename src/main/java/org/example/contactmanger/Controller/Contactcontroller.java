package org.example.contactmanger.Controller;

import org.example.contactmanger.Services.ContactService;
import org.example.contactmanger.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/Contact")
public class Contactcontroller {
    @Autowired
    private ContactService contactService;
    @DeleteMapping("/{id}")
    public Contact delete(@PathVariable int id) {
        return this.contactService.deleteContact(id);
    }
    @GetMapping("/{id}")
public Contact get(@PathVariable int id){
        return this.contactService.getContact(id);
    }
    @PostMapping(value = "/Add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> add(@RequestBody Contact contact) {
        //Object Contact;
        if(contact==null ||  contact.getName()==null || contact.getEmail() == null) {
            return ResponseEntity.badRequest().build(); // Returns HTTP 400 Bad Request
        }
        Contact ct= this.contactService.addContact(contact);
        return ResponseEntity.ok(ct);
    }
    @GetMapping("/")
    public List<Contact> getAll() {
        return this.contactService.getAllContacts();
    }

}
