package com.example.apiwords.model.DTO;

import com.example.apiwords.model.classes.Match;
import com.example.apiwords.model.classes.Player;
import com.example.apiwords.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerDTO {

    // private Integer id;
    private int score;
    private Role role;
    private String avatar_img;
    private List<Match> matches_played;

}
