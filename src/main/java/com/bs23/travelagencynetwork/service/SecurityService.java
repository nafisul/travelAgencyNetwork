package com.bs23.travelagencynetwork.service;

public interface SecurityService {
    String findLoggedInUser();
    void autoLogin(String username, String password);
}
