package com.example.apiwords.model.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "matches")
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_match")
    private Integer id_match;
    @Size(max = 5)
    private String word;
    private int score;
    @Min(0)
    @Max(6)
    private int n_try;
    private Date datetime;


}
