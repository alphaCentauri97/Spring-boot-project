package com.example.alphaCentauri.FirstWebApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloHtml {

    @GetMapping("hello-jsp")
    public String hello(){
        return "hello";
    }
}
