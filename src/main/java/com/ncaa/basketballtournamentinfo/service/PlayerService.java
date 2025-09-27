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

   public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    public void deletePlayerByName(String name) {
        playerRepository.deleteByName(name);
    }

    public List<PlayerDTO> getAllPlayersDTO() {
        return playerRepository.findAllPlayers()
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

    public PlayerDTO updatePlayer(Long id, PlayerCreateDTO playerCreateDTO) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Player with name " + playerCreateDTO.name() + " not found"));

        existingPlayer.setName(playerCreateDTO.name());
        existingPlayer.setJerseyNumber(playerCreateDTO.jerseyNumber());
        existingPlayer.setYear(playerCreateDTO.year());
        existingPlayer.setPosition(playerCreateDTO.position());
        existingPlayer.setHeight(playerCreateDTO.height());
        existingPlayer.setWeight(playerCreateDTO.weight());
        existingPlayer.setHighSchool(playerCreateDTO.highSchool());
        existingPlayer.setHometown(playerCreateDTO.hometown());

        if (playerCreateDTO.teamId() != null) {
            Team team = teamRepository.findById(playerCreateDTO.teamId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Team with id " + playerCreateDTO.teamId() + " not found"));
            existingPlayer.setTeam(team);
        } else {
            existingPlayer.setTeam(null);
        }

        Player updatedPlayer = playerRepository.save(existingPlayer);
        return mapToDTO(updatedPlayer);
    }
}
