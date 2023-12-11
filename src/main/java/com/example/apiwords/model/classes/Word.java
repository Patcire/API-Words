package com.example.apiwords.model.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "words")
@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_word")
    private Integer id_word;
    private String word;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "words_games",
            joinColumns = @JoinColumn(name = "fk_id_word"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_game"))
    private Set<Game> games_using_this_word;

}
