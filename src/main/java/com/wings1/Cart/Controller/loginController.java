package com.wings1.Cart.Controller;

import com.wings1.Cart.Configuration.JwtService;
import com.wings1.Cart.Configuration.UserInfoDetailService;
import com.wings1.Cart.Dao.AuthRequest;
import com.wings1.Cart.Dao.JwtResponse;
import com.wings1.Cart.Models.User;
import com.wings1.Cart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {
    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    JwtService jwtService;

    @Autowired
    UserRepository repo;

    @Autowired
    UserInfoDetailService userInfoDetailService;
    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException {

        UserDetails user = userInfoDetailService.loadUserByUsername(authRequest.getUsername());
        if(user !=null){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword());
            authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
            String token = jwtService.generateToken(user);
            return ResponseEntity.ok(new JwtResponse(token));
        }
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(user.);
        return ResponseEntity.status(404).body("Invalid credentials");
    }
}
