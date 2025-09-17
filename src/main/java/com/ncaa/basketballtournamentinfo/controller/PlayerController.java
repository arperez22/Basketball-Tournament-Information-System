package com.ncaa.basketballtournamentinfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ncaa.basketballtournamentinfo.service.PlayerService;
import com.ncaa.basketballtournamentinfo.dto.PlayerDTO;
import com.ncaa.basketballtournamentinfo.dto.PlayerCreateDTO;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getPlayers() {
        List<PlayerDTO> players = playerService.getAllPlayersDTO();
        return ResponseEntity.ok(players);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PlayerDTO> getPlayer(@PathVariable Long id) {
        Optional<PlayerDTO> player = playerService.getPlayerDTOById(id);
        return player.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<PlayerDTO>> searchPlayersByName(@RequestParam String name) {
        List<PlayerDTO> players = playerService.searchPlayersDTOByName(name);
        return ResponseEntity.ok(players);
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerCreateDTO dto) {
        PlayerDTO saved = playerService.createPlayer(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.id())
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long id, @RequestBody PlayerCreateDTO dto) {
        PlayerDTO updated = playerService.updatePlayer(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePlayer(@RequestParam(required = false) Long id,
                                             @RequestParam(required = false) String name) {

        if (id != null) {
            playerService.deletePlayerById(id);
        } else if (name != null) {
            playerService.deletePlayerByName(name);
        } else {
            throw new IllegalArgumentException("Must provide id or name");
        }

        return ResponseEntity.noContent().build();


    }
}
