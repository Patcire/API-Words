package com.example.apiwords.repo;

import com.example.apiwords.model.classes.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo_word extends JpaRepository<Word, Integer> {
}
