package com.wings1.Cart.Dao;

import com.wings1.Cart.Models.Role;
import com.wings1.Cart.Models.User;
import com.wings1.Cart.Repository.RoleRepository;
import com.wings1.Cart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        Role role1 = new Role();
        role1.setRole("ADMIN");

        Role role2 = new Role();
        role2.setRole("USER");

        Role saved1 = roleRepository.save(role1);
        Role saved2 = roleRepository.save(role2);


        User user1 = new User();
        user1.setUsername("ven");
        user1.setPassword("123");
        user1.setRole(saved1);
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("kam");
        user2.setPassword("321");
        user2.setRole(saved2);
        userRepository.save(user2);
    }
}
