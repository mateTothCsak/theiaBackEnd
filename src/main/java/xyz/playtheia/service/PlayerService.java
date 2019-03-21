package xyz.playtheia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.playtheia.model.Player;
import xyz.playtheia.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Component
public class PlayerService {


    private PlayerRepository playerRepository;

    public PlayerService(){ }

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void add(Player player) {
        this.playerRepository.save(player);
    }

    public void remove(Player player) {
        this.playerRepository.delete(player);
    }

    public Optional<Player> getPlayerById(Long id) {
        return this.playerRepository.findById(id);
    }

    public Player getOnePlayerById(Long id){
        return this.playerRepository.findOneById(id);
    }

    public Player getPlayerByEmail(String email){
        return (Player) this.playerRepository.findPlayerByEmail(email);
    }

    public List<Player> getAllPlayers() {
        return this.playerRepository.findAll();
    }


    public void createPlayer(String email, String name, String password) {
        Player player = new Player(email, name, password);
        add(player);
    }

    public boolean checkForExistingEmail(Player player){
        return this.playerRepository.findPlayerByEmail(player.getEmail()) != null;
    }

    public boolean checkForExistingName(Player player){
        return this.playerRepository.findPlayerByUserName(player.getUserName()) != null;
    }


    public Player tryLogIn(String email, String password){
        Player player = getPlayerByEmail(email);
        if(player != null){
            String realPassword = player.getPassword();
            String salt = player.getSalt();

            if(realPassword.equals(player.generateHash(password, salt))){
                return player;
            }
        }
        System.out.println("[TryLogIn] " + player);
        return null;
    }
}
