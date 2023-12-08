package com.example.apiwords.model.DTO;

import com.example.apiwords.model.Player;
import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {

    private Integer id;
    private String name;
    private String badge;
    private int score;
    private List<Player> player_members;

}
