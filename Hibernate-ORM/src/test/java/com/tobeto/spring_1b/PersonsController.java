package com.tobeto.spring_1b;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/persons")
public class PersonsController {

    @GetMapping
    public String get(){
        return "Abdulkadir";
    }

}

