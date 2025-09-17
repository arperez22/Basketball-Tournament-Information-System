package com.ncaa.basketballtournamentinfo.entity.player;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ncaa.basketballtournamentinfo.entity.statistics.PlayerStatistics;
import com.ncaa.basketballtournamentinfo.entity.team.Team;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="players")
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer jerseyNumber;
    @Column(name="class")
    private String year;
    private String position;
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

    public Player() {}

    public Player(String name, Integer jerseyNumber, String year, String position, String height,
                  Double weight, String hometown, String highSchool) {

        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.year = year;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.hometown = hometown;
        this.highSchool = highSchool;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public String getYear() {
        return year;
    }

    public String getPosition() {
        return position;
    }

    public String getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public String getHometown() {
        return hometown;
    }

    public String getHighSchool() {
        return highSchool;
    }


    public Team getTeam() {
        return team;
    }

    public PlayerStatistics getPlayerStatistics() {
        return playerStatistics;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setPlayerStatistics(PlayerStatistics playerStatistics) {
        this.playerStatistics = playerStatistics;

        if (playerStatistics != null && playerStatistics.getPlayer() != this) {
            playerStatistics.setPlayer(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(getId(), player.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", year='" + year + '\'' +
                ", position='" + position + '\'' +
                ", height='" + height + '\'' +
                ", weight=" + weight +
                ", hometown='" + hometown + '\'' +
                ", highSchool='" + highSchool + '\'' +
                '}';
    }
}
