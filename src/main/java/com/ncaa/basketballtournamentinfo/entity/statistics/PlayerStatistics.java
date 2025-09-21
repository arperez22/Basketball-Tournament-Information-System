package com.ncaa.basketballtournamentinfo.entity.statistics;

import com.ncaa.basketballtournamentinfo.entity.player.Player;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="player_stats")
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

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
