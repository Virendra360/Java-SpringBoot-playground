package com.dev.SpringBootPlayground.entity;

import lombok.Data;

@Data
public class ToDo {
//    "userId": 1,
//    "id": 1,
//    "title": "delectus aut autem",
//    "completed": false

    private Long userId;
    private Long id;
    private String title;
    private boolean completed;


}
