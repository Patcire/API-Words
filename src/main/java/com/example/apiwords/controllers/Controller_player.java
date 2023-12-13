package com.example.apiwords.controllers;

import com.example.apiwords.errors.custom_exceptions.Not_found_exception;
import com.example.apiwords.errors.custom_exceptions.Not_found_player;
import com.example.apiwords.model.DTO.PlayerDTO;
import com.example.apiwords.model.DTO.PlayerDTO_update;
import com.example.apiwords.model.classes.Player;
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

    @Autowired
    private ModelMapper model_mapper;

    public Controller_player(Services_player services_player) {
        this.services_player = services_player;

    }


    @GetMapping("/player/{id}")
    @ResponseBody
    public ResponseEntity<PlayerDTO> get_player_by_id(@PathVariable long id) throws Exception {
        PlayerDTO player = services_player.get_player(id);
        if (player != null) return ResponseEntity.ok(player);
        else throw new Not_found_player("No player with id " + id + " was found");
    }

    @GetMapping("/players")
    @ResponseBody
    public ResponseEntity<List<PlayerDTO>> get_all_players() {
        List<PlayerDTO> players = services_player.get_all();
        if (!players.isEmpty()) return ResponseEntity.ok(players);
        else throw new Not_found_exception("No players were found");
    }

    @PostMapping("/player")
    @ResponseBody
    public ResponseEntity<PlayerDTO> add_new_player(@Valid @RequestBody PlayerDTO playerDTO) {

        PlayerDTO created = services_player.add_player(playerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    @DeleteMapping("/player/{id}")
    @ResponseBody
    public ResponseEntity<PlayerDTO> delete_player(@PathVariable long id) {
        PlayerDTO deleted = services_player.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleted);
    }

    @PutMapping("/player/{id}")
    @ResponseBody
    public ResponseEntity<PlayerDTO_update> update_player(@PathVariable long id, @Valid @RequestBody PlayerDTO_update playerDTO_update) {
        PlayerDTO_update updated = services_player.update(id, playerDTO_update);
        return ResponseEntity.ok(updated);
    }


}





















