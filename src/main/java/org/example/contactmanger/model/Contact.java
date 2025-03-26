package org.example.contactmanger.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.internal.build.AllowNonPortable;

import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Setter
@Getter
@Entity
@AllowNonPortable
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Column
    private String discription;

    @ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "user_id", nullable = false)
    //@JsonManagedReference
    private User user;  // Single User reference instead of List<User>
public void setPassword(String password) {
    this.password = password;
}
public String getPassword() {
    return password;
}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {

    this.email = email;
    }
    public String getPhone() {
    return phone;
    }
    public void setPhone(String phone) {
    this.phone = phone;
    }
    public String getDiscription() {
    return discription;
    }
    public void setDiscription(String discription) {
    this.discription = discription;
    }
    public User getUser() {
    return user;
    }
    public void setUser(User user) {
    this.user = user;
    }
    public Integer getId() {
    return id;
    }
    public void setId(Integer id) {
    this.id = id;
    }
    public String getName() {
    return name;
    }
    public void setName(String name) {
    this.name = name;
    }
    public String getSurname() {
    return surname;
    }
    public void setSurname(String surname) {
    this.surname = surname;
    }

}
