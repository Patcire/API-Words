package com.example.apiwords.services;

import com.example.apiwords.errors.custom_exceptions.Not_found_exception;
import com.example.apiwords.model.DTO.MatchDTO;
import com.example.apiwords.model.DTO.MatchDTO_add;
import com.example.apiwords.model.classes.Match;
import com.example.apiwords.model.classes.Word;
import com.example.apiwords.repo.Repo_match;
import com.example.apiwords.repo.Repo_word;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Services_match {
    @Autowired
    private Repo_match repo_match;


    @Autowired
    private ModelMapper model_mapper;
    @Autowired
    private Repo_word repo_word;


    public MatchDTO get_match(long id) {

        return repo_match.findById(id)
                .map((element) -> model_mapper.map(element, MatchDTO.class))
                .orElseThrow(() -> new Not_found_exception("Match with id " + id + " wasn't found"));
    }

    public List<MatchDTO> get_all() {

        List<MatchDTO> matchs = new ArrayList<>();
        for (Match element : repo_match.findAll()) {
            MatchDTO map = model_mapper.map(element, MatchDTO.class);
            matchs.add(map);
        }
        if (!matchs.isEmpty()) return matchs;
        else throw new Not_found_exception("No matchs were found");

    }

    public MatchDTO_add add_match(MatchDTO_add matchDTO_add) {

        Word word_exist = repo_word.findWordByWord(matchDTO_add.getWord());
        if (word_exist != null) {
            Match dto_to_match = model_mapper.map(matchDTO_add, Match.class);
            Match created = repo_match.save(dto_to_match);
            return model_mapper.map(created, MatchDTO_add.class);
        }

        throw new Not_found_exception("You must use a word that exists in our database");

    }

    public MatchDTO delete(long id) {
        return repo_match.findById(id)
                .map(match -> {
                    repo_match.delete(match);
                    return model_mapper.map(match, MatchDTO.class);
                })
                .orElseThrow(() -> new Not_found_exception("Match with id " + id + " wasn't found"));

    }


    public MatchDTO update(long id, MatchDTO matchDTO) {

        Match match = repo_match.findById(id)
                .orElseThrow(() -> new Not_found_exception("Match with id " + id + " wasn't found"));

        // Solo vamos dejar actualizar la puntuación a los admin, por si hubiese algún fallo al haberse
        //declarado la puntuación de la partida.

        match.setScore(matchDTO.getScore());
        repo_match.save(match);
        return model_mapper.map(match, MatchDTO.class);

    }


}
