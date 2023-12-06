package com.example.apiwords.model;

import com.example.apiwords.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;


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

}
