package com.example.apiwords.model.classes;

import com.example.apiwords.model.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "words_games")
@Entity
public class Word_Game {

    @EmbeddedId
    private Word_Game_Id id_embedded;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("fk_id_game")
    @JoinColumn(name = "fk_id_game")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("fk_id_word")
    @JoinColumn(name = "fk_id_word")
    private Word word;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_word")
    private Difficulty difficultyWord;


}
