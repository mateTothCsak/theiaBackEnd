package xyz.playtheia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import xyz.playtheia.controller.requestBodies.LogInBody;
import xyz.playtheia.model.Player;
import xyz.playtheia.service.PlayerService;


@RestController
public class LogInController {

    private PlayerService playerService;

    @Autowired
    public LogInController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public Player LogIn(@RequestBody LogInBody logInBody) {
        Player result =  playerService.tryLogIn(logInBody.getEmail(), logInBody.getPassword());
        return result;
    }


}
