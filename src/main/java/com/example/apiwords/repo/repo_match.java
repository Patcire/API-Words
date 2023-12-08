package com.example.apiwords.repo;

import com.example.apiwords.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo_match extends JpaRepository<Match, Integer> {
}
