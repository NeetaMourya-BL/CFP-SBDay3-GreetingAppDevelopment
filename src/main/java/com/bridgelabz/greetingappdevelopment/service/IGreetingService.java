package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.dto.UserDto;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import java.util.Optional;

public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);
    Optional<User> getById(long id);
}