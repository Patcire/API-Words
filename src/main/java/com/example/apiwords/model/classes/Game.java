package com.example.apiwords.model.classes;

import com.example.apiwords.model.enums.Difficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer id;
    @Min(0)
    @Max(6)
    private int max_tries;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Size(max = 250)
    private String description;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_match")
    private List<Match> matches_of_that_game;
    @ManyToMany(mappedBy = "games_using_this_word")
    private Set<Word> games_using_this_word;
}
