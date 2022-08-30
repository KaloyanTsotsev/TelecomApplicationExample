package com.example.norcomapllication.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/contacts")
    public String getContacts() {
        return "/contacts";
    }
    @GetMapping("/services")
    public String getServices() {
        return "/services";
    }
}
