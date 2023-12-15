package com.example.apiwords.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "matches")
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_match")
    private long id_match;

    private String word;

    private Integer score;

    @Min(0)
    @Max(6)
    private int n_try;

    private Timestamp datetime;

    @Column(name = "fk_id_game")
    private long fk_id_game;

    @Column(name = "fk_id_player")
    private long fk_id_player;

}
