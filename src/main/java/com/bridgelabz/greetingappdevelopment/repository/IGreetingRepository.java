package com.bridgelabz.greetingappdevelopment.repository;

import com.bridgelabz.greetingappdevelopment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<User, Long> {

}