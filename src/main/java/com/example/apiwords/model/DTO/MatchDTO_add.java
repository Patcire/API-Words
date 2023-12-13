package com.example.apiwords.model.DTO;

import lombok.Data;

import java.util.Date;


@Data
public class MatchDTO_add {

    private String word;
    private Integer score = 0;
    private int n_try;
    private long fk_id_game;
    private long fk_id_player;

}
