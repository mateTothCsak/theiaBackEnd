package xyz.playtheia.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogInController {


    @GetMapping("/")
    public String greetUser() {
        return "Welcome to Theia Online";
    }
}
