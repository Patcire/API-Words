package com.example.apiwords.model.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @Size(max = 5)
    private String word;

    private int score;

    @Min(0)
    @Max(6)
    private int n_try;

    private Date datetime;

    @Column(name = "fk_id_game")
    private long fk_id_game;

    @Column(name = "fk_id_player")
    private long fk_id_player;

}
