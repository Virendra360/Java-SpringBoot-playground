package com.dev.SpringBootPlayground.controller;


import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@Controller
@RequestMapping("/resp")
public class ResponseStatusAndControllerAdvice {

    /**
     *
     * @Controller: @Controller to
     * indicate this is a typical web controller, but not necessarily
     * returning a RESTful response unless specified.
     *
     * @ResponseBody: Added @ResponseBody to each method that
     * returns data (e.g., JSON) instead of rendering a view.
     * This tells Spring to serialize the method return value directly into the HTTP response body.
     *
     * @RestController is combination of both
     */

    /**
     * Specify Content Type in @RequestMapping
     *
     * consumes = "application/json":
     * This tells Spring that the method will only accept requests with Content-Type: application/json.
     *
     * produces = "application/json":
     * This tells Spring that the method will return responses with Content-Type: application/json.
     *
     * You can safely skip the consumes and produces attributes
     * if you're fine with Spring’s default behavior,
     * especially for typical RESTful services that use JSON.
     * If you need to enforce specific content types
     * (e.g., supporting both XML and JSON, or ensuring that the client sends/receives the correct type),
     * then you should use these attributes.
     */

    /**
     * @ResponseStatus is an annotation in Spring Boot that allows you
     * to specify the HTTP status code that should be returned from a particular method
     * or when an exception is thrown. This helps provide consistent HTTP responses
     * without needing to always wrap your logic inside ResponseEntity objects.
     *
     * On Exception Classes
     * When used on an exception, @ResponseStatus tells Spring to return the specified status code
     * whenever that exception is thrown.
     * example:
     * @ResponseStatus(HttpStatus.NOT_FOUND)
     * public class UserNotFoundException extends RuntimeException {
     *     public UserNotFoundException(String message) {
     *         super(message);
     *     }
     * }
     *
     * Parameters of @ResponseStatus
     * value or code: Specifies the HTTP status code (e.g., HttpStatus.OK, HttpStatus.BAD_REQUEST, etc.).
     * reason (optional): Provides a custom reason message that can be sent as part of the response.
     *
     * By default, when you use @ResponseStatus on an exception, it doesn't return a response body, only the status and reason.
     * If you need a response body (like a custom error message in JSON), you’ll need to create a @ControllerAdvice or use an exception handler.
     *
     * @ResponseStatus and @ExceptionHandler Conflicts
     * If you annotate both an exception with @ResponseStatus and use @ExceptionHandler to handle it globally,
     * the status defined in the @ExceptionHandler will take precedence.
     *
     *
     *  HttpStatus status = HttpStatus.CREATED;
     *  int statusCode = status.value();
     *
     *  int statusCode = 201;
     *  HttpStatus status = HttpStatus.resolve(statusCode);
     */

    /**
     * Handling Exceptions for a Specific Controller
     * 1. Exception Handling Within a Specific Controller
     * You can define exception handling methods directly in a controller using @ExceptionHandler.
     * This way, the exception handling logic is only applicable to that controller.
     *
     * 2. Using @ControllerAdvice for Specific Controllers
     * If you want to apply global exception handling but still need to target specific controllers,
     * you can use @ControllerAdvice with the @ControllerAdvice's basePackages attribute
     * to limit the scope of the advice.
     * @ControllerAdvice(basePackages = "com.dev.SpringBootPlayground.controller")
     */

    /**
     *  GlobalExceptionHandling
     *  @RestControllerAdvice  ->  @ControllerAdvice + @ResponseBody is a specialized annotation in Spring that allows you to define global exception handling methods.
     *  You can use it to handle exceptions thrown by any controller in your application.
     */

    @RequestMapping(value = "/success",method = RequestMethod.GET,consumes = "application/json",produces = "application/json")
    @ResponseBody
    @ResponseStatus
    public void success(){

        System.out.println("Success call");
    }



}
