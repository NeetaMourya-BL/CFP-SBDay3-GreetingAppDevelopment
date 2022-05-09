package com.bridgelabz.greetingappdevelopment.controller;

import com.bridgelabz.greetingappdevelopment.dto.UserDto;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import com.bridgelabz.greetingappdevelopment.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping(value = { "/greeting", "/greeting/", "/greeting/home" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();
    }

    @PostMapping("/greeting")
    public User greetingMessage(@RequestBody UserDto user) {
        return greetingService.greetingMessageByName(user);
    }

    @GetMapping("/find")
    public Optional<Greeting> findGreetById(@RequestParam long id) {
        return greetingService.getById(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }

    @PutMapping("/editGreeting/{id}")
    public Greeting editGreetingById(@PathVariable("id") long id, @RequestParam(value = "name") String name) {
        return greetingService.editGreetingById(id, name);
    }

}