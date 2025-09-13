package com.ncaa.basketballtournamentinfo.entity.statistics;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="player_stats")
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    // TODO: Implement Foreign Key (Relational Mapping)
    private Integer gamesPlayed;
    private Integer gamesStarted;
    private Double minutesPlayed;
    private Double fieldGoals;
    private Double fieldGoalsAttempted;
    private Double fieldGoalPercentage;
    private Double threePoints;
    private Double threePointsAttempted;
    private Double threePointPercentage;
    private Double twoPoints;
    private Double twoPointsAttempted;
    private Double twoPointPercentage;
    private Double effectiveFieldGoalPercentage;
    private Double freeThrows;
    private Double freeThrowsAttempted;
    private Double freeThrowsPercentage;
    private Double offensiveRebounds;
    private Double defensiveRebounds;
    private Double totalRebounds;
    private Double assists;
    private Double steals;
    private Double blocks;
    private Double turnovers;
    private Double personalFouls;
    private Double pointsPerGame;

    public PlayerStatistics() {

    }

    public PlayerStatistics(Integer gamesPlayed, Integer gamesStarted, Double minutesPlayed, Double fieldGoals,
                 Double fieldGoalsAttempted, Double fieldGoalPercentage, Double threePoints,
                 Double threePointsAttempted, Double threePointPercentage, Double twoPoints,
                 Double twoPointsAttempted, Double twoPointPercentage, Double effectiveFieldGoalPercentage,
                 Double freeThrows, Double freeThrowsAttempted, Double freeThrowsPercentage,
                 Double offensiveRebounds, Double defensiveRebounds, Double totalRebounds,
                 Double assists, Double steals, Double blocks, Double personalFouls, Double pointsPerGame) {

        this.gamesPlayed = gamesPlayed;
        this.gamesStarted = gamesStarted;
        this.minutesPlayed = minutesPlayed;
        this.fieldGoals = fieldGoals;
        this.fieldGoalsAttempted = fieldGoalsAttempted;
        this.fieldGoalPercentage = fieldGoalPercentage;
        this.threePoints = threePoints;
        this.threePointsAttempted = threePointsAttempted;
        this.threePointPercentage = threePointPercentage;
        this.twoPoints = twoPoints;
        this.twoPointsAttempted = twoPointsAttempted;
        this.twoPointPercentage = twoPointPercentage;
        this.effectiveFieldGoalPercentage = effectiveFieldGoalPercentage;
        this.freeThrows = freeThrows;
        this.freeThrowsAttempted = freeThrowsAttempted;
        this.freeThrowsPercentage = freeThrowsPercentage;
        this.offensiveRebounds = offensiveRebounds;
        this.defensiveRebounds = defensiveRebounds;
        this.totalRebounds = totalRebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.personalFouls = personalFouls;
        this.pointsPerGame = pointsPerGame;
    }
}
