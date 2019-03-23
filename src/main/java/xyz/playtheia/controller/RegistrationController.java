package xyz.playtheia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public String sendRegistration(@RequestParam String email, String userName, String password) {

        if (playerService.checkForExistingEmail(email)){
            return "Email: " + email + " already exists";
        } else if (playerService.checkForExistingUserName(userName)){
            return "User name: " + userName + "already exists";
        }
        System.out.println(email + " " + userName + " " + password);
        playerService.createPlayer(email, userName, password);
        return userName + " was successfully registered";
    }

}
