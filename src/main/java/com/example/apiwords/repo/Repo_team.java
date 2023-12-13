package com.example.apiwords.repo;

import com.example.apiwords.model.classes.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo_team extends JpaRepository<Team, Long> {

    Team findByName(String name);

}
