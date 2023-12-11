package com.example.apiwords.controllers;

import com.example.apiwords.errors.custom_exceptions.Not_found_exception;
import com.example.apiwords.model.DTO.PlayerDTO;
import com.example.apiwords.model.classes.Player;
import com.example.apiwords.repo.Repo_player;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.apiwords.services.Services_player;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller_player {

    private final Services_player services_player;
    private final Repo_player repo_player;

    @Autowired
    private ModelMapper model_mapper;

    public Controller_player(Services_player services_player,
                             Repo_player repo_player) {
        this.services_player = services_player;
        this.repo_player = repo_player;
    }


    @GetMapping("/player/{id}")
    @ResponseBody
    public ResponseEntity<PlayerDTO> get_player_by_id(@PathVariable Integer id) throws Exception {
        PlayerDTO player = services_player.get_player(id);
        if (player != null) return ResponseEntity.ok(player);
        else throw new Exception("no ta");
    }

    @GetMapping("/players")
    @ResponseBody
    public ResponseEntity<List<PlayerDTO>> get_all_players() {
        List<PlayerDTO> players = services_player.get_all();
        if (!players.isEmpty()) return ResponseEntity.ok(players);
        else throw new Not_found_exception("no hayyy players jabes");
    }

    @PostMapping("/player")
    @ResponseBody
    public ResponseEntity<PlayerDTO> add_new_player(Player player) {
        PlayerDTO player_to_dto = model_mapper.map(player, PlayerDTO.class);
        PlayerDTO created = services_player.add_player(player_to_dto);
        return ResponseEntity.ok(created);
    }


}





















