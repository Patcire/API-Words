package com.example.apiwords.model.DTO;

import lombok.Data;

import java.util.Date;
import java.util.Scanner;

@Data
public class MatchDTO {

    private Integer id;
    private String word;
    private int score;
    private int n_try;
    private Date datetime;

}
