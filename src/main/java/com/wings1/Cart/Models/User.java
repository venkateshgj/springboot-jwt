package com.wings1.Cart.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;
    private String username;
    private String password;
//    @ManyToMany
//    @JoinTable(
//            name = "USER1_ROLE1",
//            joinColumns = @JoinColumn(name = "USER_ID"),
//            inverseJoinColumns = @JoinColumn(name= "ROLE_ID")
//    )
//    @JsonIgnore
//    private Set<Role> roles;

    private String role;
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
