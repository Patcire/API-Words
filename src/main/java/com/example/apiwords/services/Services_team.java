package com.example.apiwords.services;

import com.example.apiwords.errors.custom_exceptions.Exist;
import com.example.apiwords.errors.custom_exceptions.Not_found_exception;
import com.example.apiwords.model.DTO.TeamDTO;
import com.example.apiwords.model.classes.Team;
import com.example.apiwords.repo.Repo_team;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Services_team {
    @Autowired
    private Repo_team repo_team;


    @Autowired
    private ModelMapper model_mapper;


    public TeamDTO get_team(long id) {

        return repo_team.findById(id)
                .map((element) -> model_mapper.map(element, TeamDTO.class))
                .orElseThrow(() -> new Not_found_exception("Team with id " + id + " wasn't found"));
    }

    public List<TeamDTO> get_all() {

        List<TeamDTO> teams = new ArrayList<>();
        for (Team element : repo_team.findAll()) {
            TeamDTO map = model_mapper.map(element, TeamDTO.class);
            teams.add(map);
        }
        if (!teams.isEmpty()) return teams;
        else throw new Not_found_exception("No teams were found");

    }

    public TeamDTO add_team(TeamDTO teamDTO) {

        Team dto_to_team = model_mapper.map(teamDTO, Team.class);
        if (repo_team.findByName(dto_to_team.getName()) == null) {

            Team created = repo_team.save(dto_to_team);
            return model_mapper.map(created, TeamDTO.class);

        } else throw new Exist("This team_name already exist");
    }

    public TeamDTO delete(long id) {
        return repo_team.findById(id)
                .map(team -> {
                    repo_team.delete(team);
                    return model_mapper.map(team, TeamDTO.class);
                })
                .orElseThrow(() -> new Not_found_exception("Team with id " + id + " wasn't found"));

    }

    public TeamDTO update(long id, TeamDTO teamDTO) {

        Team team = repo_team.findById(id)
                .orElseThrow(() -> new Not_found_exception("Team with id " + id + " wasn't found"));

        team.setName(teamDTO.getName());
        team.setBadge(teamDTO.getBadge());
        team.setScore(teamDTO.getScore());
        teamDTO.setPlayer_members(teamDTO.getPlayer_members());
        repo_team.save(team);

        return model_mapper.map(team, TeamDTO.class);

    }
}
