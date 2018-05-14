package com.javaapp.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Uploader {

    @GetMapping("/image")
    public String index(){
        return "Upload";
    }
}
