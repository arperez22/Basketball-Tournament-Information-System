package com.ncaa.basketballtournamentinfo.dto;

public record PlayerDTO(
        Long id,
        String name,
        Integer jerseyNumber,
        String year,
        String position,
        String height,
        Double weight,
        String teamName
) {
}
