package xyz.playtheia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import xyz.playtheia.controller.requestBodies.EndGameIncome;
import xyz.playtheia.controller.requestBodies.LogInBody;
import xyz.playtheia.model.Player;
import xyz.playtheia.service.PlayerService;


@RestController
public class RewardController {

    private PlayerService playerService;

    @Autowired
    public RewardController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/collectRewards") //from backend to frontend
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public Player collectRewards(@RequestBody Long id) {
        return playerService.getOnePlayerById(id);
    }
}
