package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.dto.UserDto;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import com.bridgelabz.greetingappdevelopment.repository.IGreetingRepository;
import com.bridgelabz.greetingappdevelopment.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static String template = "Hello %s";

//  private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    IGreetingRepository iGreetingRepository;
@Autowired
    IUserRepository iUserRepository;
    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    @Override
    public User greetingMessageByName(UserDto userDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
         return iUserRepository.save(user);
    }

    @Override
    public Optional<Greeting> getById(long id) {
        Optional<Greeting> greetById = iGreetingRepository.findById(id);
        return greetById;
    }

    @Override
    public List<Greeting> getAll() {
        return iGreetingRepository.findAll();
    }

    @Override
    public Greeting editGreetingById(long id, String name) {
//        User particularGreeting = iGreetingRepository.getById(id);
        Greeting newGreeting = new Greeting(id, String.format(template, name));
      return iGreetingRepository.save(newGreeting);
    }

    @Override
    public Greeting greetingMessageByNameNew(long id, String name) {
        Greeting newGreeting = new Greeting(id, String.format(template, name));
        iGreetingRepository.save(newGreeting);
        return null;
    }

}