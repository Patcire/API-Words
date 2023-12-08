package com.example.apiwords.model.DTO;

import com.example.apiwords.model.classes.Match;
import com.example.apiwords.model.classes.Word;
import com.example.apiwords.model.enums.Difficulty;
import lombok.Data;


import java.util.List;

import java.util.Set;

@Data
public class GameDTO {

    private Integer id;
    private int max_tries;
    private Difficulty difficulty;
    private String description;
    private List<Match> matches_of_that_game;
    private Set<Word> games_using_this_word;

}

