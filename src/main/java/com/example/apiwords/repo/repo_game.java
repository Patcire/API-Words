package com.example.apiwords.repo;

import com.example.apiwords.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo_game extends JpaRepository<Game, Integer> {
}
