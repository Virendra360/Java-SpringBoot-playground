package com.dev.SpringBootPlayground;

import com.dev.SpringBootPlayground.entity.User;
import com.dev.SpringBootPlayground.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootPlaygroundApplication {

	/**
	 *  Code to initialize the database only one time
	 *  PostConstruct runs on server start / restart everytime
	 */

//	@Autowired
//	UserRepository userRepository;
//
//	@PostConstruct
//	public void init() {
//
//		List<User> userList =new ArrayList<>();
//		IntStream.range(1,200).forEach(i->{
//		  User user= new User((long) i,"USER-"+i,"user"+i+"@gmail.com","USER-"+i+"@77");
//			userList.add(user);
//		});
//		userRepository.saveAll(userList);
//		System.out.println("Initializing database...");
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPlaygroundApplication.class, args);
	}

}
