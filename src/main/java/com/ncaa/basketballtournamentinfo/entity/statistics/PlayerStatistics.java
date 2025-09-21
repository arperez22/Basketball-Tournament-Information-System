package com.ncaa.basketballtournamentinfo.entity.statistics;

import com.ncaa.basketballtournamentinfo.entity.player.Player;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="player_stats")
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer gamesPlayed;

    @NotNull
    private Integer gamesStarted;

    @NotNull
    private Double minutesPlayed;

    @NotNull
    private Double fieldGoals;

    @NotNull
    private Double fieldGoalsAttempted;

    private Double fieldGoalPercentage;

    @NotNull
    private Double threePoints;

    @NotNull
    private Double threePointsAttempted;

    private Double threePointPercentage;

    @NotNull
    private Double twoPoints;

    @NotNull
    private Double twoPointsAttempted;

    private Double twoPointPercentage;

    private Double effectiveFieldGoalPercentage;

    @NotNull
    private Double freeThrows;

    @NotNull
    private Double freeThrowsAttempted;

    private Double freeThrowsPercentage;

    @NotNull
    private Double offensiveRebounds;

    @NotNull
    private Double defensiveRebounds;

    @NotNull
    private Double totalRebounds;

    @NotNull
    private Double assists;

    @NotNull
    private Double steals;

    @NotNull
    private Double blocks;

    @NotNull
    private Double turnovers;

    @NotNull
    private Double personalFouls;

    @NotNull
    private Double pointsPerGame;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id", referencedColumnName = "id", nullable = false)
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;

        if(player != null && player.getPlayerStatistics() != this) {
            player.setPlayerStatistics(this);
        }
    }
}
