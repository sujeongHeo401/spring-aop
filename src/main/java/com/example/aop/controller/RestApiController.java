package com.example.aop.controller;

import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        System.out.println("get method");

        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        System.out.println("total time: " + stopWatch.getTotalTimeSeconds());
        return user;


    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException{

        // db logic
        Thread.sleep(1000 * 2);

    }
}
