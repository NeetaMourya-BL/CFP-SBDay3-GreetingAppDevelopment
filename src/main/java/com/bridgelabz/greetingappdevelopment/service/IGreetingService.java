package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.component.UserComponent;
import com.bridgelabz.greetingappdevelopment.model.Greeting;

public interface IGreetingService {
    Greeting greetingMessage();

    String greetingMessageByName(UserComponent userComponent);
}