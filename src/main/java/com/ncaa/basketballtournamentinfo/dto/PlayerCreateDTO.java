package com.ncaa.basketballtournamentinfo.dto;

public record PlayerCreateDTO(
        String name,
        Integer jerseyNumber,
        String year,
        String position,
        String height,
        Double weight,
        String highSchool,
        String hometown,
        Long teamId
) {
}
