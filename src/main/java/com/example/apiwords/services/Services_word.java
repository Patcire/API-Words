package com.example.apiwords.services;

import com.example.apiwords.model.classes.Word;
import com.example.apiwords.repo.Repo_word;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class Services_word {
    @Autowired
    private Repo_word repo_word;


    @Autowired
    private ModelMapper model_mapper;


    public List<String> get_random_words(int number) {

        List<Word> words = repo_word.findAll();


        List<String> random_words = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < number; i++) {
            Word random_word = words.get(random.nextInt(words.size()));
            random_words.add(random_word.getWord());
        }

        return random_words;
    }
}
