package com.example.apiwords.repo;

import com.example.apiwords.model.classes.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo_team extends JpaRepository<Team, Integer> {
}
