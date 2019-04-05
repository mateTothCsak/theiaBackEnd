package xyz.playtheia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import xyz.playtheia.controller.requestBodies.EndGameIncome;
import xyz.playtheia.controller.requestBodies.LogInBody;
import xyz.playtheia.controller.requestBodies.PurchaseBody;
import xyz.playtheia.model.Player;
import xyz.playtheia.service.PlayerService;


@RestController
public class GameController {


    private PlayerService playerService;

    @Autowired
    public GameController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/startGame")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void startGame(@RequestBody Long id) {
        playerService.updateLastGameStarted(id);
    }

    @PostMapping("/currentPlayer")
    @CrossOrigin(origins = "http://localhost", allowCredentials = "true")
    public Player currentPlayer() {
        System.out.println("Got requestyyyy");
        return playerService.findLatestPlayer();
    }




}
