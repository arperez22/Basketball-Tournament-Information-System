package com.ncaa.basketballtournamentinfo.entity.team;

import com.ncaa.basketballtournamentinfo.entity.player.Player;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name="teams")
public class Team {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String record;
    private Integer wins;
    private Integer losses;
    private Integer conferenceWins;
    private Integer conferenceLosses;
    private String university;
    private String coach;
    private String conference;
    private String location;
    private String nickname;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    public Team(String name, String record, Integer wins, Integer losses, Integer conferenceWins,
                Integer conferenceLosses, String university, String coach, String conference,
                String location, String nickname) {

        this.name = name;
        this.record = record;
        this.wins = wins;
        this.losses = losses;
        this.conferenceWins = conferenceWins;
        this.conferenceLosses = conferenceLosses;
        this.university = university;
        this.coach = coach;
        this.conference = conference;
        this.location = location;
        this.nickname = nickname;
    }

    public Team() {

    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getRecord() {
        return record;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public Integer getConferenceWins() {
        return conferenceWins;
    }

    public Integer getConferenceLosses() {
        return conferenceLosses;
    }

    public String getUniversity() {
        return university;
    }

    public String getCoach() {
        return coach;
    }

    public String getConference() {
        return conference;
    }

    public String getLocation() {
        return location;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setTeam(this);
    }

    public void removePlayer(Player player) {
        players.remove(player);
        player.setTeam(null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public void setConferenceWins(Integer conferenceWins) {
        this.conferenceWins = conferenceWins;
    }

    public void setConferenceLosses(Integer conferenceLosses) {
        this.conferenceLosses = conferenceLosses;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(getId(), team.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", record='" + record + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", conferenceWins=" + conferenceWins +
                ", conferenceLosses=" + conferenceLosses +
                ", university='" + university + '\'' +
                ", coach='" + coach + '\'' +
                ", conference='" + conference + '\'' +
                ", location='" + location + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
