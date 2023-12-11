package com.example.apiwords.repo;

import com.example.apiwords.model.DTO.PlayerDTO;
import com.example.apiwords.model.classes.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repo_player extends JpaRepository<Player, Integer> {

   
}
