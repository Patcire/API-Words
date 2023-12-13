package com.example.apiwords.services;

import com.example.apiwords.errors.custom_exceptions.Not_found_player;
import com.example.apiwords.errors.custom_exceptions.Exist;
import com.example.apiwords.model.DTO.PlayerDTO;
import com.example.apiwords.model.DTO.PlayerDTO_update;
import com.example.apiwords.model.classes.Player;
import com.example.apiwords.repo.Repo_player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;


@Service
public class Services_player {

    @Autowired
    private Repo_player repo_player;


    @Autowired
    private ModelMapper model_mapper;


    public PlayerDTO get_player(long id) {

        return repo_player.findById(id)
                .map((element) -> model_mapper.map(element, PlayerDTO.class))
                .orElse(null);

    }

    public List<PlayerDTO> get_all() {

        return repo_player.findAll().stream()
                .map((element) -> model_mapper.map(element, PlayerDTO.class)).collect(Collectors.toList());

    }

    public PlayerDTO add_player(PlayerDTO playerDTO) {

        Player dto_to_player = model_mapper.map(playerDTO, Player.class);
        if (repo_player.findByName(dto_to_player.getName()) == null) {

            Player created = repo_player.save(dto_to_player);
            return model_mapper.map(created, PlayerDTO.class);

        } else throw new Exist("This player_name already exist");
    }

    public PlayerDTO delete(long id) {
        return repo_player.findById(id)
                .map(player -> {
                    repo_player.delete(player);
                    return model_mapper.map(player, PlayerDTO.class);
                })
                .orElseThrow(() -> new Not_found_player("Player with id " + id + " wasn't found"));

    }

    public PlayerDTO_update update(long id, PlayerDTO_update playerDTO_update) {

        Player player = repo_player.findById(id)
                .orElseThrow(() -> new Not_found_player("Player with id " + id + " wasn't found"));

        player.setName(playerDTO_update.getName());
        player.setAvatar_img(playerDTO_update.getAvatar_img());
        repo_player.save(player);

        return model_mapper.map(player, PlayerDTO_update.class);

    }


}
