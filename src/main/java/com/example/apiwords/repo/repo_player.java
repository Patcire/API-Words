package com.example.apiwords.repo;

import com.example.apiwords.model.classes.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo_player extends JpaRepository<Player, Integer> {
}
