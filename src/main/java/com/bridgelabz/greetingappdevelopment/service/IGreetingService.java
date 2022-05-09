package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.dto.UserDto;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    Greeting greetingMessage();
    User greetingMessageByName(UserDto userDto);
    Optional<Greeting> getById(long id);

    List<Greeting> getAll();

    Greeting editGreetingById(long id, String name);

}