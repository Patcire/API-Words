package com.example.apiwords.model.DTO;

import com.example.apiwords.model.Match;
import com.example.apiwords.model.enums.Role;
import lombok.Data;


import java.util.List;

@Data
public class PlayerDTO {

    private Integer id;
    private int score;
    private Role role;
    private String avatar_img;
    private List<Match> matches_played;

}
