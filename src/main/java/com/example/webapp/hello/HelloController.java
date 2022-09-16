package com.example.webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @RequestMapping("hello")
    @ResponseBody
    public String sayHello() {
        return "Hello there!";
    }

    @RequestMapping("hello-jsp")
    public String sayHelloJsp(@RequestBody(required = true) String body) {
        return "sayHello";
    }
}
