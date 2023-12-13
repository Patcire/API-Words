package com.example.apiwords.model.DTO;

import lombok.Data;

import java.util.Date;


@Data
public class MatchDTO {

    private String word;
    private int score;
    private int n_try;
    private Date datetime;

}
