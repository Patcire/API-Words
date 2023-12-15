package com.example.apiwords.model.classes;

import com.example.apiwords.model.enums.Difficulty;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "games")
@Entity
public class Game {
    // PONER VALIDATED EN EL CONTROLADOR
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")
    private long id_game;

    @Min(0)
    @Max(6)
    private long max_tries;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Size(max = 250)
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy = "fk_id_game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Match> matches_of_that_game;

    @JsonBackReference
    @OneToMany(mappedBy = "game",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Word_Game> words_used_by_this_game;
}
