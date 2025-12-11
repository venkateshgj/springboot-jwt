package com.wings1.Cart.Controller;

import com.wings1.Cart.Dao.AuthRequest;
import com.wings1.Cart.Models.User;
import com.wings1.Cart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class loginController {

    @Autowired
    UserRepository repo;
    private ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException {

        User user = repo.findByUsername(authRequest.getUsername()).orElseThrow(()-> new UsernameNotFoundException("Invalid username"));
        BCrypt
        return null;
    }
}
