package com.dev.SpringBootPlayground.controller;

import com.dev.SpringBootPlayground.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClient;

    @GetMapping("/getData")
    public ResponseEntity<?> getData() throws IOException, InterruptedException {

        String url= "https://jsonplaceholder.typicode.com/todos";

        /**
         * HttpClient
         */

        HttpRequest request= HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpClient client= HttpClient.newBuilder().build();

         HttpResponse response= client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());

        /**
         *  WebClient
         *  It is modern way to api communication, RestTemplate is depreciated
         */

//      List l= webClient.build()
//                .get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(List.class)
//                .block();
//
//        System.out.println(l);

//       List l= webClient.build()
//                .get()
//                .uri(url)
//                .exchangeToMono((response)->{
//                    if(response.statusCode()== HttpStatusCode.valueOf(200))
//                        return response.bodyToMono(List.class);
//                    else
//                        return null;
//                })
//                .block();
//
//        System.out.println(l);

        /**
         * RestTemplate
         */

        //1. use getForEntity, get list and then map list to ToDo class list
//        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
//
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getBody());

        //2. use exchange for list

//        ResponseEntity<List<ToDo>> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<ToDo>>() {}
//        );
//
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getBody());

        return ResponseEntity.accepted().body("Hello");
    }

}
