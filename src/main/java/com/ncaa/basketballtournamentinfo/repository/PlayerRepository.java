package com.ncaa.basketballtournamentinfo.repository;

import com.ncaa.basketballtournamentinfo.entity.player.Player;
import com.ncaa.basketballtournamentinfo.entity.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByName(String name);
    List<Player> findByNameStartsWith(String name);
    List<Player> findByTeam(Team team);
    List<Player> findByTeamAndName(Team team, String name);

}
