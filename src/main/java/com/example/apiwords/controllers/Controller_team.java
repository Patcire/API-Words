package com.example.apiwords.controllers;

import com.example.apiwords.errors.custom_exceptions.Not_found_exception;
import com.example.apiwords.model.DTO.TeamDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.apiwords.services.Services_team;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller_team {

    private final Services_team services_team;

    @Autowired
    private ModelMapper model_mapper;

    public Controller_team(Services_team services_team) {
        this.services_team = services_team;

    }


    @GetMapping("/team/{id}")
    @ResponseBody
    public ResponseEntity<TeamDTO> get_team_by_id(@PathVariable long id) {
        TeamDTO team = services_team.get_team(id);
        if (team != null) return ResponseEntity.ok(team);
        else throw new Not_found_exception("No team with id " + id + " was found");
    }

    @GetMapping("/teams")
    @ResponseBody
    public ResponseEntity<List<TeamDTO>> get_all_teams() {
        List<TeamDTO> teams = services_team.get_all();
        if (!teams.isEmpty()) return ResponseEntity.ok(teams);
        else throw new Not_found_exception("No teams were found");
    }

    @PostMapping("/team")
    @ResponseBody
    public ResponseEntity<TeamDTO> add_new_team(@Valid @RequestBody TeamDTO teamDTO) {

        TeamDTO created = services_team.add_team(teamDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    @DeleteMapping("/team/{id}")
    @ResponseBody
    public ResponseEntity<TeamDTO> delete_team(@PathVariable long id) {
        TeamDTO deleted = services_team.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleted);
    }

    @PutMapping("/team/{id}")
    @ResponseBody
    public ResponseEntity<TeamDTO> update_team(@PathVariable long id, @Valid @RequestBody TeamDTO teamDTO) {
        TeamDTO updated = services_team.update(id, teamDTO);
        return ResponseEntity.ok(updated);
    }


}


