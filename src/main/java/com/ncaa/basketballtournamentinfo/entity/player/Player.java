package com.ncaa.basketballtournamentinfo.entity.player;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ncaa.basketballtournamentinfo.entity.statistics.PlayerStatistics;
import com.ncaa.basketballtournamentinfo.entity.team.Team;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="players")
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer jerseyNumber;

    @NotNull
    @Column(name="class")
    private String year;

    @NotNull
    private String position;

    @NotNull
    private String height;

    private Double weight;

    private String hometown;

    private String highSchool;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @JsonBackReference
    private Team team;

    @OneToOne(mappedBy = "player")
    @JsonIgnore
    private PlayerStatistics playerStatistics;

    public void setPlayerStatistics(PlayerStatistics playerStatistics) {
        this.playerStatistics = playerStatistics;

        if (playerStatistics != null && playerStatistics.getPlayer() != this) {
            playerStatistics.setPlayer(this);
        }
    }
}
