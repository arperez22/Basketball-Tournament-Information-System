package com.ncaa.basketballtournamentinfo.entity.team;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ncaa.basketballtournamentinfo.entity.player.Player;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String record;

    private Integer wins;

    private Integer losses;

    private Integer conferenceWins;

    private Integer conferenceLosses;

    @NotNull
    private String university;

    @NotNull
    private String coach;

    @NotNull
    private String conference;

    @NotNull
    private String location;

    private String nickname;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL,  orphanRemoval = true)
    @JsonManagedReference
    private List<Player> players = new ArrayList<>();
}
