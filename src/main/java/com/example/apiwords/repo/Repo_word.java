package com.example.apiwords.repo;

import com.example.apiwords.model.classes.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo_word extends JpaRepository<Word, Integer> {
    Word findWordByWord(String word);
}
