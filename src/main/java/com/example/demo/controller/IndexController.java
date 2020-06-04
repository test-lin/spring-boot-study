package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/")
    public String index(@RequestParam(name = "name", defaultValue = "world")String name) {
        // Get http://localhost:8080?name=spring
        return String.format("hello %s!", name);
    }
}
