package com.example.apiwords.controllers;

import com.example.apiwords.errors.custom_exceptions.Not_found_exception;
import com.example.apiwords.model.DTO.MatchDTO;
import com.example.apiwords.model.DTO.MatchDTO_add;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.apiwords.services.Services_match;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller_match {

    private final Services_match services_match;

    @Autowired
    private ModelMapper model_mapper;

    public Controller_match(Services_match services_match) {
        this.services_match = services_match;

    }


    @GetMapping("/match/{id}")
    @ResponseBody
    public ResponseEntity<MatchDTO> get_match_by_id(@PathVariable long id) {
        MatchDTO match = services_match.get_match(id);
        if (match != null) return ResponseEntity.ok(match);
        else throw new Not_found_exception("No match with id " + id + " was found");
    }

    @GetMapping("/matches")
    @ResponseBody
    public ResponseEntity<List<MatchDTO>> get_all_matchs() {
        List<MatchDTO> matchs = services_match.get_all();
        if (!matchs.isEmpty()) return ResponseEntity.ok(matchs);
        else throw new Not_found_exception("No matchs were found");
    }

    @PostMapping("/match")
    @ResponseBody
    public ResponseEntity<MatchDTO_add> add_new_match(@Valid @RequestBody MatchDTO_add matchDTO_add) {

        MatchDTO_add created = services_match.add_match(matchDTO_add);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    @DeleteMapping("/match/{id}")
    @ResponseBody
    public ResponseEntity<MatchDTO> delete_match(@PathVariable long id) {
        MatchDTO deleted = services_match.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleted);
    }

    @PutMapping("/match/{id}")
    @ResponseBody
    public ResponseEntity<MatchDTO> update_match(@PathVariable long id, @Valid @RequestBody MatchDTO matchDTO) {
        MatchDTO updated = services_match.update(id, matchDTO);
        return ResponseEntity.ok(updated);
    }


}

