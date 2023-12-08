package com.example.apiwords.model.DTO;

import com.example.apiwords.model.classes.Game;
import lombok.Data;

import java.util.Set;

@Data
public class WordDTO {

    private Integer id;
    private String word;
    private Set<Game> games_using_this_word;

}
