package com.ncaa.basketballtournamentinfo.service;

import com.ncaa.basketballtournamentinfo.repository.PlayerRepository;
import com.ncaa.basketballtournamentinfo.entity.player.Player;
import com.ncaa.basketballtournamentinfo.entity.team.Team;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public List<Player> getPlayersByTeam(Team team) {
        return playerRepository.findByTeam(team);
    }

    public List<Player> getPlayersByYear(String year) {
        return playerRepository.findByYear(year);
    }

    public List<Player> getPlayersByPosition(String position) {
        return playerRepository.findByPosition(position);
    }

    public List<Player> searchPlayersByName(String searchText) {
        return playerRepository.findByNameContainingIgnoreCase(searchText);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findById(updatedPlayer.getId());

        if (existingPlayer.isPresent()) {
            Player player = existingPlayer.get();

            player.setName(updatedPlayer.getName());
            player.setYear(updatedPlayer.getYear());
            player.setPosition(updatedPlayer.getPosition());
            player.setHometown(updatedPlayer.getHometown());
            player.setHighSchool(updatedPlayer.getHighSchool());
            player.setTeam(updatedPlayer.getTeam());

            return playerRepository.save(player);
        }

        return null;
    }

    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }

    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}
