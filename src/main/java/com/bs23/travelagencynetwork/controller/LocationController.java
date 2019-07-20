package com.bs23.travelagencynetwork.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {
    private static final Logger logger = LogManager.getLogger(LocationController.class);
    @GetMapping("/location")
    public String index(){
        return "";
    }
}
