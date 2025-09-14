package com.ncaa.basketballtournamentinfo.repository;

import com.ncaa.basketballtournamentinfo.entity.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByName(String teamName);
    List<Team> findByConference(String teamConference);

}