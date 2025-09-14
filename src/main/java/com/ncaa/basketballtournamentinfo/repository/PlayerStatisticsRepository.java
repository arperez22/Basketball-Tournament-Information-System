package com.ncaa.basketballtournamentinfo.repository;

import com.ncaa.basketballtournamentinfo.entity.statistics.PlayerStatistics;
import com.ncaa.basketballtournamentinfo.entity.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, Long> {

    Optional<PlayerStatistics> findByPlayer_Name(String name);
    List<PlayerStatistics> findByPlayer_Team(Team team);

}
