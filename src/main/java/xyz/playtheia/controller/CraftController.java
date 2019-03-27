package xyz.playtheia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import xyz.playtheia.controller.requestBodies.LogInBody;
import xyz.playtheia.controller.requestBodies.PurchaseBody;
import xyz.playtheia.model.Player;
import xyz.playtheia.service.PlayerService;


@RestController
public class CraftController {


    private PlayerService playerService;

    @Autowired
    public CraftController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/craft")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void LogIn(@RequestBody PurchaseBody purchaseBody) throws Exception {
        Long id = purchaseBody.getId();
        Integer gold = purchaseBody.getGold();
        String sidekick = purchaseBody.getSidekick();
        String side = purchaseBody.getSide();
        playerService.purchaseSidekick(id, gold, sidekick, side);
    }


}
