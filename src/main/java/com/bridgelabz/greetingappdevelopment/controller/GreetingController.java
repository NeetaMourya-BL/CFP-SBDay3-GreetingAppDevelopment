package com.bridgelabz.greetingappdevelopment.controller;

import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import com.bridgelabz.greetingappdevelopment.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = { "/greeting", "/greeting/", "/greeting/home" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(),String.format(template, greeting.getGreeting()));
    }
    @PutMapping("/putGreeting/{counter}")
    public Greeting sayHello(@PathVariable long counter, @RequestParam(value = "content")String content){
        return new Greeting(counter,String.format(template, content));
    }
    @Autowired
    private IGreetingService greetingService;

    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();
    }
    @PostMapping("/greeting")
    public String greetingMessage(@RequestBody User user) {
        return "Hello "+user.firstName+" "+user.lastName;
    }
}