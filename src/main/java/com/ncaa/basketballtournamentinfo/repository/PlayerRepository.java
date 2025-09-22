package com.ncaa.basketballtournamentinfo.repository;

import com.ncaa.basketballtournamentinfo.entity.player.Player;
import com.ncaa.basketballtournamentinfo.entity.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT DISTINCT p FROM Player p " +
           "LEFT JOIN FETCH p.playerStatistics " +
           "JOIN FETCH p.team")
    List<Player> findAllPlayers();
    List<Player> findByNameContainingIgnoreCase(String name);
    List<Player> findByTeam(Team team);
    List<Player> findByYear(String year);
    List<Player> findByPosition(String position);
    void deleteByName(String name);
}
