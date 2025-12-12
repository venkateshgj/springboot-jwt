package com.wings1.Cart.Dao;

import java.net.http.HttpResponse;

public class JwtResponse {
    private String token;
//    private HttpResp response

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
