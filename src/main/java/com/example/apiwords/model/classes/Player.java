package com.example.apiwords.model.classes;

import com.example.apiwords.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "players")
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int score;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Size(max = 150)
    private String avatar_img;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_match")
    private List<Match> matches_played;

}
