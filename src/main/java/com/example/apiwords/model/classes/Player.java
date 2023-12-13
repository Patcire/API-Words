package com.example.apiwords.model.classes;

import com.example.apiwords.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "players")
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private long id_player;

    private int score;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Size(max = 20)
    private String name;

    @Size(max = 150)
    private String avatar_img;

    @JsonBackReference
    @OneToMany(mappedBy = "fk_id_player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Match> matches_played;


    @Column(name = "fk_id_team")
    private long fk_id_team;

}
