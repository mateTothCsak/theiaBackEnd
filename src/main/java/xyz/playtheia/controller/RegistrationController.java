package xyz.playtheia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.playtheia.controller.requestBodies.RegisterBody;
import xyz.playtheia.model.Player;
import xyz.playtheia.service.PlayerService;


@RestController
public class RegistrationController {


    PlayerService playerService;

    @Autowired
    RegistrationController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping("/registration")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public boolean sendRegistration(@RequestBody RegisterBody registerBody) {
        String email = registerBody.getEmail();
        String password = registerBody.getPassword();
        String userName = registerBody.getUserName();

        if (playerService.checkForExistingEmail(email)){
            return false;
        } else if (playerService.checkForExistingUserName(userName)){
            return false;
        }
        System.out.println(email + " " + userName + " " + password);
        playerService.createPlayer(email, userName, password);
        return true;
    }

}
