package com.wings1.Cart.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DummyController {

    @GetMapping("/allow")
    public ResponseEntity<?> dummy(@RequestHeader("JWT") String token){
        return ResponseEntity.ok("done");
    }
}
