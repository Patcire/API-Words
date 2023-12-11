package com.example.apiwords.services;

import com.example.apiwords.model.DTO.PlayerDTO;
import com.example.apiwords.model.classes.Player;
import com.example.apiwords.repo.Repo_player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@Service
public class Services_player {

    @Autowired
    private Repo_player repo_player;


    @Autowired
    private ModelMapper model_mapper;


    public PlayerDTO get_player(Integer id) {

        return repo_player.findById(id)
                .map((element) -> model_mapper.map(element, PlayerDTO.class))
                .orElse(null);


    }

    public List<PlayerDTO> get_all() {

        return repo_player.findAll().stream()
                .map((element) -> model_mapper.map(element, PlayerDTO.class)).collect(Collectors.toList());

    }

    public PlayerDTO add_player(@Valid @RequestBody PlayerDTO playerDTO) {
        Player dto_to_player = model_mapper.map(playerDTO, Player.class);
        Player created = repo_player.save(dto_to_player);
        return model_mapper.map(created, PlayerDTO.class);
    }

   
}
