package com.example.apiwords.repo;

import com.example.apiwords.model.classes.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo_player extends JpaRepository<Player, Long> {

    Player findByName(String player_name);

}
