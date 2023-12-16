package com.example.apiwords.controllers;

import com.example.apiwords.errors.custom_exceptions.Not_found_exception;
import com.example.apiwords.services.Services_word;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller_word {

    private final Services_word services_word;

    @Autowired
    private ModelMapper model_mapper;

    public Controller_word(Services_word services_word) {
        this.services_word = services_word;

    }


    @GetMapping("/word/{number}")
    @ResponseBody
    public ResponseEntity<List<String>> get_word_by_id(@PathVariable int number) {

        List<String> random_words = services_word.get_random_words(number);
        if (!random_words.isEmpty()) return ResponseEntity.ok(random_words);
        else throw new Not_found_exception("No random words were generated");
    }


}