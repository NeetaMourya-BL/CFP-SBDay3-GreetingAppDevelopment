package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.component.UserComponent;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import com.bridgelabz.greetingappdevelopment.repository.IGreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    IGreetingRepository iGreetingRepository;

    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    @Override
    public String greetingMessageByName(UserComponent userComponent) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map();
        iGreetingRepository.save(user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }
}