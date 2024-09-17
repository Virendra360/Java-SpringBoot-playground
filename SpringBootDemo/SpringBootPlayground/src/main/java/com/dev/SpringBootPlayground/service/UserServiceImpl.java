package com.dev.SpringBootPlayground.service;

import com.dev.SpringBootPlayground.entity.User;
import com.dev.SpringBootPlayground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Pagination example
     */
    public Page<User> getUsersByPage(int page, int pageSize){

        Pageable pageable= PageRequest.of(page,pageSize);
        return userRepository.findAll(pageable);
    }

    /**
     * Sorting example
     */
    public List<User> getUsersBySort(String field){
        return userRepository.findAll(Sort.by(field));
    }

    /**
     *  Pagination and Sorting combine
     */
    public Page<User> getUsersByPageAndSort(int page, int pageSize, String field){
        // By default, direction is Ascending
        Pageable pageable = PageRequest.of(page,pageSize,Sort.by(Sort.Direction.ASC,field));
        return userRepository.findAll(pageable);
    }
}
