package com.example.apiwords.model.classes;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Word_Game_Id implements Serializable {

    @Column(name = "id_word")
    private long fk_id_word;

    @Column(name = "id_game")
    private long fk_id_game;

    public Word_Game_Id() {
    }

    public Word_Game_Id(long fk_id_word, long fk_id_game) {
        this.fk_id_game = fk_id_game;
        this.fk_id_word = fk_id_word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word_Game_Id that = (Word_Game_Id) o;
        return fk_id_game == that.fk_id_game &&
                fk_id_word == that.fk_id_word;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fk_id_game, fk_id_word);
    }
}

