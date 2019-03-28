package xyz.playtheia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import xyz.playtheia.controller.requestBodies.EndGameIncome;
import xyz.playtheia.controller.requestBodies.LogInBody;
import xyz.playtheia.model.Player;
import xyz.playtheia.service.PlayerService;


@RestController
public class WealthController {

    private PlayerService playerService;

    @Autowired
    public WealthController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/updateWealth") //from phaser to database
    @CrossOrigin(origins = "http://localhost", allowCredentials = "true")
    public Player updateWealth(@RequestBody EndGameIncome endGameIncome) {
        Long id = endGameIncome.getId();
        Integer experience = endGameIncome.getExperience();
        Integer gold = endGameIncome.getGold();
        playerService.updatePlayerWealth(id, experience, gold);
        return playerService.getOnePlayerById(id);
    }

}
