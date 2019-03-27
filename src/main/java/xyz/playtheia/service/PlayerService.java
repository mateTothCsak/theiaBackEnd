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

    public boolean checkForExistingEmail(String email){
        return this.playerRepository.findPlayerByEmail(email) != null;
    }

    public boolean checkForExistingUserName(String userName){
        return this.playerRepository.findPlayerByUserName(userName) != null;
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

    public void purchaseSidekick(Long id, int gold, String sidekick, String side) throws Exception {
        Player player = this.getOnePlayerById(id);
        player.setGold(player.getGold() + gold);
        if(side.equals("left")){
            player.setLeftSidekick(sidekick);
        } else if (side.equals("right")){
            player.setRightSidekick(sidekick);
        }
        this.playerRepository.save(player);
        System.out.println("Save done");
    }
}
