package com.example.apiwords.model.DTO;

import com.example.apiwords.model.classes.Player;
import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {

    private String name;
    private String badge;
    private int score;
    private List<Player> player_members;

}
