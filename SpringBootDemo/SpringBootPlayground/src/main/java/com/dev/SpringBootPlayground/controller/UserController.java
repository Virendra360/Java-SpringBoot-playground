package com.dev.SpringBootPlayground.controller;

import com.dev.SpringBootPlayground.entity.User;
import com.dev.SpringBootPlayground.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList= userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    /**
     *Pageable example  -> Pageable is use to query data
     * PageRequest.of(int page, int pageSize) class method provide Pageable object, Pageable is interface
     * Page is also interface which has results plus metadata
     */

    @GetMapping("/{page}/{pageSize}")
    public ResponseEntity<List<User>> getUsersByPage(@PathVariable int page, @PathVariable int pageSize){
        Page<User> userPage= userService.getUsersByPage(page,pageSize);
        List<User> userList=userPage.getContent();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{field}")
    public ResponseEntity<List<User>> getUsersBySort(@PathVariable String field){
        List<User> userList= userService.getUsersBySort(field);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{page}/{pageSize}/{field}")
    public ResponseEntity<List<User>> getUsersByPageAndSort(@PathVariable int page, @PathVariable int pageSize, @PathVariable String field){
        Page<User> userList= userService.getUsersByPageAndSort(page,pageSize,field);
        return new ResponseEntity<>(userList.getContent(), HttpStatus.OK);
    }

}
