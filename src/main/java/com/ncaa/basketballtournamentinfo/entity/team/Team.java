package com.ncaa.basketballtournamentinfo.entity.team;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ncaa.basketballtournamentinfo.entity.player.Player;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonManagedReference
    private List<Player> players = new ArrayList<>();
}
