package com.ncaa.basketballtournamentinfo.service;

import com.ncaa.basketballtournamentinfo.dto.PlayerCreateDTO;
import com.ncaa.basketballtournamentinfo.repository.PlayerRepository;
import com.ncaa.basketballtournamentinfo.repository.TeamRepository;
import com.ncaa.basketballtournamentinfo.entity.player.Player;
import com.ncaa.basketballtournamentinfo.entity.team.Team;
import com.ncaa.basketballtournamentinfo.dto.PlayerDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
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

    public void deletePlayerByName(String name) {
        playerRepository.deleteByName(name);
    }

    public List<PlayerDTO> getAllPlayersDTO() {
        return playerRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public Optional<PlayerDTO> getPlayerDTOById(Long id) {
        return playerRepository.findById(id).map(this::mapToDTO);
    }

    public List<PlayerDTO> searchPlayersDTOByName(String searchText) {
        return playerRepository.findByNameContainingIgnoreCase(searchText)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private PlayerDTO mapToDTO(Player player) {
        String teamName = player.getTeam() != null ? player.getTeam().getName() : null;
        return new PlayerDTO(
                player.getId(),
                player.getName(),
                player.getJerseyNumber(),
                player.getYear(),
                player.getPosition(),
                player.getHeight(),
                player.getWeight(),
                teamName
        );
    }

    public PlayerDTO createPlayer(PlayerCreateDTO playerCreateDTO) {
        Player player = new Player();

        player.setName(playerCreateDTO.name());
        player.setJerseyNumber(playerCreateDTO.jerseyNumber());
        player.setYear(playerCreateDTO.year());
        player.setPosition(playerCreateDTO.position());
        player.setHeight(playerCreateDTO.height());
        player.setWeight(playerCreateDTO.weight());
        player.setHighSchool(playerCreateDTO.highSchool());
        player.setHometown(playerCreateDTO.hometown());

        if (playerCreateDTO.teamId() != null) {
            Team team = teamRepository.findById(playerCreateDTO.teamId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Team with id " + playerCreateDTO.teamId()+ " not found"));
            player.setTeam(team);
        }

        Player saved = playerRepository.save(player);
        return mapToDTO(saved);
    }

    public PlayerDTO updatePlayer(Long id, PlayerCreateDTO playerDTO) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Player with name " + playerDTO.name() + " not found"));

        existingPlayer.setName(playerDTO.name());
        existingPlayer.setJerseyNumber(playerDTO.jerseyNumber());
        existingPlayer.setYear(playerDTO.year());
        existingPlayer.setPosition(playerDTO.position());
        existingPlayer.setHeight(playerDTO.height());
        existingPlayer.setWeight(playerDTO.weight());
        existingPlayer.setHighSchool(playerDTO.highSchool());
        existingPlayer.setHometown(playerDTO.hometown());

        if (playerDTO.teamId() != null) {
            Team team = teamRepository.findById(playerDTO.teamId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Team with id " + playerDTO.teamId() + " not found"));
            existingPlayer.setTeam(team);
        } else {
            existingPlayer.setTeam(null);
        }

        Player updatedPlayer = playerRepository.save(existingPlayer);
        return mapToDTO(updatedPlayer);
    }
}
