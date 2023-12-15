package com.example.apiwords.model.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "teams")
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team")
    private long id_team;

    private String name;

    private String badge;

    private int score;

    @JsonBackReference
    @OneToMany(mappedBy = "fk_id_team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Player> player_members;

}
