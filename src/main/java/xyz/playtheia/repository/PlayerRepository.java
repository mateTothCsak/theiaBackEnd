package xyz.playtheia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import xyz.playtheia.model.Player;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findPlayerByEmail(@Param("email") String email);

    Player findPlayerByUserName(@Param("userName") String userName);

    Player findOneById(@Param("id") Long id);

}
